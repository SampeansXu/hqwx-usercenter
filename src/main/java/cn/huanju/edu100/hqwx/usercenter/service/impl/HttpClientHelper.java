package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.config.HQWXUsercenterConfig;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import cn.huanju.edu100.hqwx.usercenter.utils.UCMD5Util;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
@Component("SDK_HQWX_Usercenter_httpClientHelper")
public class HttpClientHelper {
    private static Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);

    @Resource
    HttpClientConnectionManager httpClientConnectionManager;
    @Resource
    RequestConfig requestConfig;
    @Resource
    HQWXUsercenterConfig config;


    ScheduledExecutorService scheduledThreadPool = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    private void start() {
        final long SleepTime_Sec = 10;

        this.scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!scheduledThreadPool.isShutdown()) {
                    if (Objects.nonNull(httpClientConnectionManager)) {
                        httpClientConnectionManager.closeExpiredConnections();
                        httpClientConnectionManager.closeIdleConnections(30, TimeUnit.SECONDS);
                    }
                }
//                System.out.println(new Date());
            }
        }, SleepTime_Sec, SleepTime_Sec, TimeUnit.SECONDS);
    }

    @PreDestroy
    private void stop() {
        this.scheduledThreadPool.shutdown();

        System.out.println("HttpClientHelper will destroy");
        if (Objects.nonNull(logger)) {
            logger.info("HttpClientHelper will destroy");
        }
    }

    public HQWXUsercenterConfig getConfig() {
        return this.config;
    }

    public CloseableHttpClient createHttpClient() {
        if (Objects.isNull(this.httpClientConnectionManager) || Objects.isNull(this.requestConfig)) {
            System.out.println("HttpClientConnectionManager or RequestConfig is null");
            if (Objects.nonNull(logger)) {
                logger.error("HttpClientConnectionManager or RequestConfig is null");
            }

            return null;
        }

        return HttpClientBuilder.create()
                .setConnectionManager(this.httpClientConnectionManager)
                .setDefaultRequestConfig(this.requestConfig)
                .build();
    }

    public UCRequest createUCRequest(Long schId) {
        UCRequest request = new UCRequest();
        long reqTime = System.currentTimeMillis() / 1000;
        String reqSign = UCMD5Util.generateMD5(this.config.getAppKey() + "|"
                + this.config.getAppId() + "|"
                + this.config.getPlatform() + "|"
                + reqTime);

        request.setPlatform(this.config.getPlatform());
        request.setAppId(this.config.getAppId());
        request.setOrgId(schId);
        request.setReqTime(reqTime);
        request.setReqSign(reqSign);
        request.setReqSeq(UUID.randomUUID().getMostSignificantBits());

        return request;
    }

    public Map<String, Object> createParamData(BizBaseData baseData) {
        if (Objects.isNull(baseData)) {
            baseData = new BizBaseData();
        }
        if (StringUtils.isEmpty(baseData.getAppId())) {
            baseData.setAppId(this.config.getAppId());
        }
        if (StringUtils.isEmpty(baseData.getPlatform())) {
            baseData.setPlatform(this.config.getPlatform());
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appid", baseData.getAppId());
        params.put("platform", baseData.getPlatform());
        params.put("optUser", UserCenterApiConstant.Default_OptUser);

        return params;
    }

    private String makeHttpUrl(String httpApi) {
        String httpUrl = this.config.getHostUrl();
        if (Objects.isNull(httpUrl) || Objects.isNull(httpApi)) {
            if (Objects.nonNull(logger)) {
                logger.error("URL error. HostUrl={}, HttpApi={}", httpUrl, httpApi);
            }

            return null;
        }

        if (httpUrl.substring(httpUrl.length() - 1).equals("/")) {
            httpUrl = httpUrl.substring(0, httpUrl.length() - 1);
        }

        return httpUrl + httpApi;
    }

    public UCResponse doPost(String httpApi, UCRequest request) {
        CloseableHttpClient httpclient = this.createHttpClient();
        if (Objects.isNull(httpclient) || Objects.isNull(request)) {
            if (Objects.nonNull(logger)) {
                logger.error("httpclient is null{} or request is null{}.", httpclient == null, request == null);
            }

            return null;
        }

        String httpUrl = makeHttpUrl(httpApi);
        System.out.println("[HttpClientHelper] httpUrl=" + httpUrl);
        if (Objects.nonNull(logger)) {
            logger.debug("httpUrl={}", httpUrl);
        }
        if (Objects.isNull(httpUrl)) {
            if (Objects.nonNull(logger)) {
                logger.debug("httpUrl is null");
            }

            return null;
        }

        UCResponse ucResponse = null;
        try {
//            System.out.println("[HttpClientHelper] " + request.toString());
            String postJson = UCGsonUtil.toJson(request);
            HttpPost httpPost = new HttpPost(httpUrl);
            httpPost.addHeader("Content-type","application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(postJson, Charset.forName("UTF-8")));
            HttpResponse httpResponse = httpclient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(httpResponse.getEntity());
                ucResponse = UCGsonUtil.fromJson(result, UCResponse.class);

                System.out.println("[HttpClientHelper] result=" + result);
                if(Objects.isNull(ucResponse) || !ucResponse.isOk())
                {
                    if (Objects.nonNull(logger)) {
                        logger.error("[HttpClientHelper] failed. result={}", result);
                    }
                }
            }
        } catch (Error e) {
            e.printStackTrace();
            if (Objects.nonNull(logger)) {
                logger.error("DoPost error. HttpUrl:{}, {}, {}.", httpUrl, request.toString(), ucResponse.toString(), e);
            }
        } finally {
            return ucResponse;
        }

    }

//    public UCResponse doGet(Map<String, Object> params) {
//
//    }
}

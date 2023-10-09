package cn.huanju.edu100.hqwx.usercenter.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: 配置
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
@Configuration
@ComponentScan({"cn.huanju.edu100.hqwx.usercenter.service.impl"})
public class HQWXUsercenterConfig {
    //用户中心接入配置
    @Value("${hquc.ucfg.app-id:203}")
    private String appId;

    @Value("${hquc.ucfg.app-key:tuQXM7BnIN2TirVP}")
    private String appKey;

    @Value("${hquc.ucfg.platform:srv}")
    private String platform;

    @Value("${hquc.ucfg.host-url:http://uapi.98809.com}")
    private String hostUrl;

    //Http链接配置
    @Value("${hquc.http.pool-size:500}")
    private Integer poolSize;

    @Value("${hquc.http.response-timeout:5000}")
    private Integer socketTimeout;//单位 毫秒(ms)

    @Value("${hquc.http.request-timeout:5000}")
    private Integer connectionRequestTimeout;//单位 毫秒(ms)

    private Integer connectTimeout = 5 * 1000;// 单位 毫秒(ms)

    public String getAppId() {
        return appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getHostUrl() {
        return hostUrl;
    }

    public String getPlatform() {
        return platform;
    }


    /**
     * HttpClientConnectionManager 连接池
     *
     * @return
     */
    @Bean("SDK_HQWX_UserCenter_httpClientConnectionManager")
    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(this.poolSize);
        connectionManager.setDefaultMaxPerRoute(this.poolSize);
        return connectionManager;
    }

    /**
     * RequestConfig
     *
     * @return
     */
    @Bean("SDK_HQWX_UserCenter_requestConfig")
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(this.connectTimeout)
                .setConnectionRequestTimeout(this.connectionRequestTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
    }
}

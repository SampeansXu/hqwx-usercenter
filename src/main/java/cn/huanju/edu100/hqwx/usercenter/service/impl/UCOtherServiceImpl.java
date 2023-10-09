package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.api.UCOtherService;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.SendSmsCodeDTO;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-28
 */
@Service("SDK_HQWX_UserCenter_otherService")
public class UCOtherServiceImpl implements UCOtherService {

    @Resource
    HttpClientHelper httpClientHelper;

    @Override
    public HQUCResponse<SendSmsCodeDTO> sendSmsCode(String phone, String optStr, Long schId) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(optStr) || Objects.isNull(schId)) {
            return HQUCResponse.Error("phone or optStr or schId is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(null);
        params.put("phone", phone);
        params.put("optStr", optStr);
        params.put("appid", httpClientHelper.getConfig().getAppId());
        params.put("clientIp", "127.0.0.1");
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_sendSmsCode, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            SendSmsCodeDTO resultDTO = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), SendSmsCodeDTO.class);

            return HQUCResponse.Ok(resultDTO);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }
}

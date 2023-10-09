package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.api.RegisterService;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.api.AuthTokenDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.RegisterResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import cn.huanju.edu100.hqwx.usercenter.utils.UCSHA1Util;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-02
 */
@Service("SDK_HQWX_UserCenter_registerService")
public class RegisterServiceImpl implements RegisterService {

    @Resource
    HttpClientHelper httpClientHelper;

    private HQUCResponse<RegisterResponseDTO> internalRegister(String uName, String phone, String email, String password, String nickName, Long schId, BizBaseData baseData) {
        if (StringUtils.isEmpty(uName) && StringUtils.isEmpty(phone) && StringUtils.isEmpty(email)) {
            return HQUCResponse.Error("uName and phone and email are null");
        }
        if (Objects.isNull(schId) || StringUtils.isEmpty(password)) {
            return HQUCResponse.Error("schId or password is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("passWord", password);
        if (StringUtils.hasText(uName)) {
            params.put("uName", uName);
        } else if (StringUtils.hasText(phone)) {
            params.put("phone", phone);
        } else if (StringUtils.hasText(email)) {
            params.put("email", email);
        }

        if (StringUtils.hasText(nickName)) {
            params.put("nickName", nickName);
        }
        params.put("sha1Pwd", UCSHA1Util.generateSHA1(password));
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_internalRegister, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            RegisterResponseDTO resultDTO = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), RegisterResponseDTO.class);

            return HQUCResponse.Ok(resultDTO);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }


    @Override
    public HQUCResponse<RegisterResponseDTO> internalRegister(String uName, String password, String nickName, Long schId) {
        return this.internalRegister(uName, password, nickName, schId, null);
    }

    @Override
    public HQUCResponse<RegisterResponseDTO> internalRegister(String uName, String password, String nickName, Long schId, BizBaseData baseData) {
        if (Objects.isNull(schId) || StringUtils.isEmpty(uName) || StringUtils.isEmpty(password)) {
            return HQUCResponse.Error("schId or uName or password is null");
        }

        return this.internalRegister(uName, null, null, password, nickName, schId, baseData);
    }

    private HQUCResponse<RegisterResponseDTO> register(String phone, String email, String verifyCode, String password, String nickName, Long schId, BizBaseData baseData) {
        if (StringUtils.isEmpty(phone) && StringUtils.isEmpty(email)) {
            return HQUCResponse.Error("phone and email are null");
        }
        if (StringUtils.isEmpty(verifyCode) || Objects.isNull(schId) || StringUtils.isEmpty(password)) {
            return HQUCResponse.Error("verifyCode or schId or password is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("passWord", password);
        if (StringUtils.hasText(phone)) {
            params.put("phone", phone);
            params.put("smsCode", verifyCode);
        } else if (StringUtils.hasText(email)) {
            params.put("email", email);
            params.put("emailCode", verifyCode);
        }

        if (StringUtils.hasText(nickName)) {
            params.put("nickName", nickName);
        }
        params.put("sha1Pwd", UCSHA1Util.generateSHA1(password));
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_register, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            RegisterResponseDTO resultDTO = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), RegisterResponseDTO.class);

            return HQUCResponse.Ok(resultDTO);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<RegisterResponseDTO> register(String phone, String verifyCode, String password, String nickName, Long schId) {
        return this.register(phone, verifyCode, password, nickName, schId, null);
    }

    @Override
    public HQUCResponse<RegisterResponseDTO> register(String phone, String verifyCode, String password, String nickName, Long schId, BizBaseData baseData) {
        if (Objects.isNull(schId) || StringUtils.isEmpty(phone)  || StringUtils.isEmpty(verifyCode)|| StringUtils.isEmpty(password)) {
            return HQUCResponse.Error("schId or phone or verifyCode or password is null");
        }

        return this.register(phone, null, verifyCode, password, nickName, schId, baseData);
    }
}

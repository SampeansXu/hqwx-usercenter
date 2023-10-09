package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.api.UserLoginService;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.LoginResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.ThirdLoginRequestDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.ThirdLoginResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import cn.huanju.edu100.hqwx.usercenter.utils.UCSHA1Util;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description: 用户登陆
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-12
 */
@Service("SDK_HQWX_UserCenter_userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    HttpClientHelper httpClientHelper;

    interface LoginType{
        int UName=1;
        int Phone=2;
    }
    private HQUCResponse<LoginResponseDTO> login(int loginType, String loginAccount, String password, Long schId, BizBaseData baseData){
        if (StringUtils.isEmpty(loginAccount) || StringUtils.isEmpty(password) || Objects.isNull(schId)) {
            return HQUCResponse.Error("param has null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("sha1Pwd", UCSHA1Util.generateSHA1(password));
        if(LoginType.Phone==loginType){
            params.put("phone", loginAccount);
        }else{
            params.put("uname", loginAccount);
        }
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_login, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            LoginResponseDTO dto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), LoginResponseDTO.class);
            return HQUCResponse.Ok(dto);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<Object> changePasswordByUName(String uName, String newPassword, Long schId) {
        if (StringUtils.isEmpty(uName) || StringUtils.isEmpty(newPassword) || Objects.isNull(schId)) {
            return HQUCResponse.Error("param has null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(null);
        params.put("UName", uName);
        params.put("Sha1NewPwd", UCSHA1Util.generateSHA1(newPassword));
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_adminResetPassWord, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk()) {
            return HQUCResponse.Ok(response.getData());
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }

    @Override
    public HQUCResponse<LoginResponseDTO> loginByPhone(String phone, String password, Long schId, BizBaseData baseData) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password) || Objects.isNull(schId)) {
            return HQUCResponse.Error("phone or password or schId is null");
        }

        return login(LoginType.Phone, phone, password, schId, baseData);
    }

    @Override
    public HQUCResponse<LoginResponseDTO> loginByUName(String uName, String password, Long schId, BizBaseData baseData) {
        if (StringUtils.isEmpty(uName) || StringUtils.isEmpty(password) || Objects.isNull(schId)) {
            return HQUCResponse.Error("uName or password or schId is null");
        }

        return login(LoginType.UName, uName, password, schId, baseData);
    }

    @Override
    public HQUCResponse<ThirdLoginResponseDTO> thirdLogin(ThirdLoginRequestDTO param, Long schId) {
        if (StringUtils.isEmpty(param.getAppId())
                || StringUtils.isEmpty(param.getOpenId()) || Objects.isNull(schId)) {
            return HQUCResponse.Error("AppId or OpenId or schId is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        BeanMap beanMap = BeanMap.create(param);
        Map<String, Object> params = new HashMap<>();
        beanMap.forEach((key, value) -> {
            params.put(String.valueOf(key), value);
        });
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_thirdLogin, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            ThirdLoginResponseDTO dto = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), ThirdLoginResponseDTO.class);
            return HQUCResponse.Ok(dto);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }
}

package cn.huanju.edu100.hqwx.usercenter.service.impl;

import cn.huanju.edu100.hqwx.usercenter.api.UCTokenService;
import cn.huanju.edu100.hqwx.usercenter.constant.UserCenterApiConstant;
import cn.huanju.edu100.hqwx.usercenter.model.api.AuthTokenDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCRequest;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.UCResponse;
import cn.huanju.edu100.hqwx.usercenter.utils.UCGsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-20
 */
@Service("SDK_HQWX_UserCenter_tokenService")
public class UCTokenServiceImpl implements UCTokenService {

    @Resource
    HttpClientHelper httpClientHelper;

    @Override
    public HQUCResponse<AuthTokenDTO> authToken(Long schId, String sourceToken) {
        return this.authToken(schId, sourceToken, null);
    }

    @Override
    public HQUCResponse<AuthTokenDTO> authToken(Long schId, String sourceToken, BizBaseData baseData) {
        if (Objects.isNull(schId) || StringUtils.isEmpty(sourceToken)) {
            return HQUCResponse.Error("schId or sourceToken is null");
        }
        if (Objects.isNull(httpClientHelper)) {
            return HQUCResponse.Error("HttpClientHelper is null");
        }

        UCRequest request = httpClientHelper.createUCRequest(schId);
        Map<String, Object> params = httpClientHelper.createParamData(baseData);
        params.put("token", sourceToken);
        request.setData(params);


        UCResponse response = httpClientHelper.doPost(UserCenterApiConstant.API_authToken, request);
        if (Objects.isNull(response)) {
            return HQUCResponse.Error("UserCenter over time");
        }

        if (response.isOk() && response.getData() != null) {
            AuthTokenDTO resultDTO = UCGsonUtil.fromJson(UCGsonUtil.toJson(response.getData()), AuthTokenDTO.class);

            return HQUCResponse.Ok(resultDTO);
        }

        return HQUCResponse.response(response.getrCode(), response.getrMsg());
    }
}

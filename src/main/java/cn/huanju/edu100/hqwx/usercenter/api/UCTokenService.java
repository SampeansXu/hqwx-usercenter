package cn.huanju.edu100.hqwx.usercenter.api;

import cn.huanju.edu100.hqwx.usercenter.model.api.AuthTokenDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;

/**
 * @Description: Token相关，如Token鉴权
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-19
 */
public interface UCTokenService {
    HQUCResponse<AuthTokenDTO> authToken(Long schId, String sourceToken);
    HQUCResponse<AuthTokenDTO> authToken(Long schId, String sourceToken, BizBaseData baseData);
}

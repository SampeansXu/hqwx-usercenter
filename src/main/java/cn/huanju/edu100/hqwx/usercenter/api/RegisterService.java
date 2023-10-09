package cn.huanju.edu100.hqwx.usercenter.api;

import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.RegisterResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;

/**
 * @Description: 注册相关
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-02
 */
public interface RegisterService {
    HQUCResponse<RegisterResponseDTO> internalRegister(String uName, String password, String nickName, Long schId);
    HQUCResponse<RegisterResponseDTO> internalRegister(String uName, String password, String nickName, Long schId, BizBaseData baseData);

    HQUCResponse<RegisterResponseDTO> register(String phone, String verifyCode, String password, String nickName, Long schId);
    HQUCResponse<RegisterResponseDTO> register(String phone, String verifyCode, String password, String nickName, Long schId, BizBaseData baseData);
}

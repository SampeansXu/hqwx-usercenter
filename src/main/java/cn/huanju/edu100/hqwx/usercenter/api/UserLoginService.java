package cn.huanju.edu100.hqwx.usercenter.api;

import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.LoginResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.ThirdLoginRequestDTO;
import cn.huanju.edu100.hqwx.usercenter.model.api.ThirdLoginResponseDTO;
import cn.huanju.edu100.hqwx.usercenter.model.usercenter.BizBaseData;

/**
 * @Description: 用户登陆
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-12
 */
public interface UserLoginService {
    /**
     * 通过帐号uName，修改用户密码
     * @param uName
     * @param newPassword
     * @param schId
     * @return
     */
    HQUCResponse<Object> changePasswordByUName(String uName, String newPassword, Long schId);

    /**
     * 手机号密码登陆
     * @param phone
     * @param password
     * @return
     */
    HQUCResponse<LoginResponseDTO> loginByPhone(String phone, String password, Long schId, BizBaseData baseData);

    /**
     * 账号密码登陆
     * @param uName
     * @param password
     * @param schId
     * @return
     */
    HQUCResponse<LoginResponseDTO> loginByUName(String uName, String password, Long schId, BizBaseData baseData);

    /**
     * 第三方登录
     */
    HQUCResponse<ThirdLoginResponseDTO> thirdLogin(ThirdLoginRequestDTO param, Long schId);
}

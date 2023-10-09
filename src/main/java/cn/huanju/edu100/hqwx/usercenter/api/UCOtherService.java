package cn.huanju.edu100.hqwx.usercenter.api;

import cn.huanju.edu100.hqwx.usercenter.model.api.HQUCResponse;
import cn.huanju.edu100.hqwx.usercenter.model.api.SendSmsCodeDTO;

/**
 * @Description: 各种其它接口
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-28
 */
public interface UCOtherService {
    /**
     *
     * @param phone
     * @param optStr 取值[UserCenterConstant.SendSmsOpt.]
     *             register :用户注册
     *             login:    用户登录
     *             resetpwd :重置密码
     *             bindphone :绑定手机号码
     *             formsubmit: 表单提交
     * @return
     */
    HQUCResponse<SendSmsCodeDTO> sendSmsCode(String phone, String optStr, Long schId);
}

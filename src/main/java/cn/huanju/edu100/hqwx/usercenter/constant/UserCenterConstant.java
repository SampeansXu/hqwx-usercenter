package cn.huanju.edu100.hqwx.usercenter.constant;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-29
 */
public interface UserCenterConstant {
    /**
     * 短信发送类型
     */
    interface SendSmsOpt {
        String Register = "register";//用户注册
        String Login = "login";//用户登录
        String ResetPwd = "resetpwd";//重置密码
        String BindPhone = "bindphone";//绑定手机号码
        String FormSubmit = "formsubmit";//表单提交

    }
}

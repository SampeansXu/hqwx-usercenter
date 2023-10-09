package cn.huanju.edu100.hqwx.usercenter.constant;

/**
 * @Description: 用户中心 http业务接口
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
public class UserCenterApiConstant {

    //默认机构Id
    public static final Long Default_OrgId = 2L;

    //默认操作用户
    public static final String Default_OptUser = "hqwx-usercenter";

    //内部用户用户注册
    public final static String API_internalRegister = "/internalRegister";

    //用户用户注册
    public final static String API_register = "/register";

    //用户登陆
    public final static String API_login = "/login";

    //第三方登陆
    public final static String API_thirdLogin = "/thirdLogin";

    //修改密码
    public final static String API_adminResetPassWord = "/adminResetPassWord";

    //管理员修改所属用户的信息
    public final static String API_adminUpdateUserInfo = "/adminUpdateUserInfo";

    //管理系统 绑定手机号码
    public static final String API_adminBindPhone = "/adminBindPhone";

    //修改用户的信息
    public final static String API_updateUserInfo = "/updateUserInfo";

    //管理系统 查询用户信息
    public static final String API_adminGetUserInfo = "/adminGetUserInfo";

    //管理系统 批量查询用户信息
    public static final String API_adminGetUserByList = "/adminGetUserByList";

    //管理系统 查询账号第三方信息
    public static final String API_adminGetThirdUserInfo = "/adminGetThirdUserInfo";

    //查询用户的考试意向 与updateUserInfo接口对应
    public final static String API_getUserSortID = "/getUserSortID";

    //查看用户感兴趣的考试,浏览过的考试和考试意向 与addInterestedSortId接口对应
    public final static String API_getSortIdInfo = "/getSortIdInfo";

    //查询用户手机号
    public final static String API_getUserPhone = "/getUserPhone";

    //Token鉴权
    public final static String API_authToken = "/authToken";

    //发送短信
    public final static String API_sendSmsCode = "/sendSmsCode";
}

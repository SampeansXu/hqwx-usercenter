package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: 用户登陆 反馈
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-12
 */
public class LoginResponseDTO implements Serializable {
//		private String accList; //可选|用户可访问的业务列表,以","进行分隔
        private Integer bindWeChat; //用户是否绑定了微信服务号
        private String devToken; //设备token
        private String faceUrl; //用户的头像
        private Integer isMobileVerified; //是否手机已验证
        private Integer loginReg; //login时,账号不存在,新注册了一个新的账号. true:新注册了账号
        private String nickName; //昵称
        private Integer orgId; //用户注册时所在的机构
//        private String phone; //用户手机 有掩码 139****0624
        private String secInfo; //安全信息
        private Integer sex; //性别
        private String token; //登录成功时生成的Token
        private Long tokenEtime; //Token的过期时间
        private Integer topOrg; //用户所在一级机构的ID
        private Long uid; //用户UID
        private String uName; //用户名
//需要APP/PC端显示的额外信息
//    "msgInfo": {
//        "msg": "",
//                "msgID": "",
//                "msgOpt": [
//        {}
//			],
//        "msgParam": {}
//    },


    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "bindWeChat=" + bindWeChat +
                ", devToken='" + devToken + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", isMobileVerified=" + isMobileVerified +
                ", loginReg=" + loginReg +
                ", nickName='" + nickName + '\'' +
                ", orgId=" + orgId +
                ", secInfo='" + secInfo + '\'' +
                ", sex=" + sex +
                ", token='" + token + '\'' +
                ", tokenEtime=" + tokenEtime +
                ", topOrg=" + topOrg +
                ", uid=" + uid +
                ", uName='" + uName + '\'' +
                '}';
    }

    public Integer getBindWeChat() {
        return bindWeChat;
    }

    public void setBindWeChat(Integer bindWeChat) {
        this.bindWeChat = bindWeChat;
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Integer getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Integer isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Integer getLoginReg() {
        return loginReg;
    }

    public void setLoginReg(Integer loginReg) {
        this.loginReg = loginReg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getSecInfo() {
        return secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenEtime() {
        return tokenEtime;
    }

    public void setTokenEtime(Long tokenEtime) {
        this.tokenEtime = tokenEtime;
    }

    public Integer getTopOrg() {
        return topOrg;
    }

    public void setTopOrg(Integer topOrg) {
        this.topOrg = topOrg;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}

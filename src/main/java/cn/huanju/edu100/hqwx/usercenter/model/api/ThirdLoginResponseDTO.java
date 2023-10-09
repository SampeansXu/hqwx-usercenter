package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: ThirdLoginResponseDTO
 * @Author: xushengbin@hqwx.com
 * @Date: 2023-01-16
 * @Ver: v1.0 -create
 */
public class ThirdLoginResponseDTO implements Serializable {
    private String devToken; //设备token
    private Long uid;
    private String uname; //用户名
    private String nickName; //昵称
    private String faceUrl; //用户头像
    private String phone; //用户手机 有掩码 139****0624
    private Integer sex;
    private String sortId;
    private Integer isMobileVerified; //是否手机已验证
    private boolean loginReg; //login时,账号不存在,新注册了一个新的账号. true:新注册了账号
    private ThirdLoginMsgInfoDTO msgInfo; //需要APP/PC端显示的额外信息
    private String secInfo; //安全信息
    private Long thirdId; //新用户体系针对第三方显示的ID
    private String token; //登录成功时生成的Token
    private Long tokenEtime; //Token的过期时间
    private Long orgId;
    private Long topOrg;

    public ThirdLoginResponseDTO() {
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public Integer getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Integer isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public boolean isLoginReg() {
        return loginReg;
    }

    public void setLoginReg(boolean loginReg) {
        this.loginReg = loginReg;
    }

    public ThirdLoginMsgInfoDTO getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(ThirdLoginMsgInfoDTO msgInfo) {
        this.msgInfo = msgInfo;
    }

    public String getSecInfo() {
        return secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
    }

    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getTopOrg() {
        return topOrg;
    }

    public void setTopOrg(Long topOrg) {
        this.topOrg = topOrg;
    }
}

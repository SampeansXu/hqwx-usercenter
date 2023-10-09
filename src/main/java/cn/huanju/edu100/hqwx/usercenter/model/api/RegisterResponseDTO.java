package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: 注册反馈用户信息
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-02
 */
public class RegisterResponseDTO implements Serializable {
    private Long uid; //用户UID
    private String faceUrl; //头像地址
    private String nickName; //昵称
    private String uName; //用户名
    private Integer orgId; //用户注册时所在的机构
    private Integer sex; //性别
    private Integer topOrg; //用户所在顶级机构的ID
    private Integer isMobileVerified; //是否绑定手机
    private String phone; //电话号
    private String secInfo;
    private String token; //Token
    private Long tokenEtime; //Token过期时间
    private String sortId; //考试意向

    @Override
    public String toString() {
        return "RegisterResponseDTO{" +
                "uid=" + uid +
                ", faceUrl='" + faceUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", uName='" + uName + '\'' +
                ", orgId=" + orgId +
                ", sex=" + sex +
                ", topOrg=" + topOrg +
                ", isMobileVerified=" + isMobileVerified +
                ", phone='" + phone + '\'' +
                ", secInfo='" + secInfo + '\'' +
                ", token='" + token + '\'' +
                ", tokenEtime=" + tokenEtime +
                ", sortId='" + sortId + '\'' +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getTopOrg() {
        return topOrg;
    }

    public void setTopOrg(Integer topOrg) {
        this.topOrg = topOrg;
    }

    public Integer getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Integer isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecInfo() {
        return secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
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

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }
}

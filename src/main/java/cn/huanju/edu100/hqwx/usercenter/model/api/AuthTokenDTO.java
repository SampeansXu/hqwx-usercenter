package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: Token鉴权 返回数据
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-19
 */
public class AuthTokenDTO implements Serializable {
    private Long uid; //登陆用户Uid
    private String uName; //只有是当一次性鉴权Token的时候才有用户名

    private Long topOrg; //顶级机构id
    private Long orgId; //机构id

    private String tAppid; //Token生成时，请求中的appid.
    private String tPlatform; //Token生成时，请求中的platform

    private Long remainSecond; //Token剩下的有效秒数


    @Override
    public String toString() {
        return "AuthTokenDTO{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", topOrg=" + topOrg +
                ", orgId=" + orgId +
                ", tAppid='" + tAppid + '\'' +
                ", tPlatform='" + tPlatform + '\'' +
                ", remainSecond=" + remainSecond +
                '}';
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

    public Long getTopOrg() {
        return topOrg;
    }

    public void setTopOrg(Long topOrg) {
        this.topOrg = topOrg;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String gettAppid() {
        return tAppid;
    }

    public void settAppid(String tAppid) {
        this.tAppid = tAppid;
    }

    public String gettPlatform() {
        return tPlatform;
    }

    public void settPlatform(String tPlatform) {
        this.tPlatform = tPlatform;
    }

    public Long getRemainSecond() {
        return remainSecond;
    }

    public void setRemainSecond(Long remainSecond) {
        this.remainSecond = remainSecond;
    }
}

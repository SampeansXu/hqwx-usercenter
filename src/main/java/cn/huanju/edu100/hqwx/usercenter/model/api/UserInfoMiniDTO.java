package cn.huanju.edu100.hqwx.usercenter.model.api;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @Description: 用户极简信息
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-09
 */
public class UserInfoMiniDTO implements Serializable {
    private Long uid; //用户UID
    private String name; //用户真实性
    private String nickName; //用户昵称
    private String uName; //用户名
    private String faceUrl; //头像URL地址
    private Integer sex; //用户性别 0-未知 1-男 2-女
    private Long unionId; //平台统一Id

    /**
     * 获取显示名称 昵称 -> 用户名
     * @return
     */
    public String getShowName() {
        return !StringUtils.isEmpty(this.nickName) ? this.nickName : this.uName;
    }

    @Override
    public String toString() {
        return "UserInfoMiniDTO{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", uName='" + uName + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", sex=" + sex +
                ", unionId=" + unionId +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }
}

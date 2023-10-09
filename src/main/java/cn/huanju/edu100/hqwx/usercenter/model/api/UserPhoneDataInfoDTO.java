package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-10-22
 */
public class UserPhoneDataInfoDTO implements Serializable {
    private Long uid;
    private String personPhone; //用户个人信息表手机号
    private String phone; //用户绑定手机号
    private String uName;

    @Override
    public String toString() {
        return "UserPhoneDataInfoDTO{" +
                "uid=" + uid +
                ", personPhone='" + personPhone + '\'' +
                ", phone='" + phone + '\'' +
                ", uName='" + uName + '\'' +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}

package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: ThirdUserInfoDTO
 * @Author: xushengbin@hqwx.com
 * @Date: 2022-10-20
 * @Ver: v1.0 -create
 */
public class ThirdUserInfoDTO implements Serializable {
    private String openId; //OpenID
    private Integer source;	//来源
    private String srvName;	//SrvName
    private Long thirdId;	//对外的第三方ID
    private String thirdInfo;	//第三方的信息描述
    private Long uid;	//用户UID

    public ThirdUserInfoDTO() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getSrvName() {
        return srvName;
    }

    public void setSrvName(String srvName) {
        this.srvName = srvName;
    }

    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdInfo() {
        return thirdInfo;
    }

    public void setThirdInfo(String thirdInfo) {
        this.thirdInfo = thirdInfo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}

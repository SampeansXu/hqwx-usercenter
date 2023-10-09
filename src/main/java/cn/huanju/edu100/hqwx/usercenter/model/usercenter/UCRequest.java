package cn.huanju.edu100.hqwx.usercenter.model.usercenter;

import java.io.Serializable;

/**
 * @Description: 用户中心 请求基础数据
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
public class UCRequest implements Serializable {
    //业务模块定义（转发时填写转源
    private String appId;

    //Data 和 Context二选一 优先解析context
    private String context;

    //Data/Context二选一|各业务具体的参数
    private Object data;

    //机构信息
    private Long orgId;

    //平台终端定义（转发时填写转源）
    private String platform;

    //请求中序列. 建议在一段时间内不重复
    private Long reqSeq;

    //数据签名信息
    private String reqSign;

    //请求发出的系统时间Unix秒数
    private Long reqTime;

    //用于版本控制中的特殊处理
    private Integer reqVer;

    //测试控制用，调用方请忽略这个字段
    private String optToken;


    @Override
    public String toString() {
        return "UCRequest{" +
                "appId='" + appId + '\'' +
                ", context='" + context + '\'' +
                ", data=" + data +
                ", orgId=" + orgId +
                ", platform='" + platform + '\'' +
                ", reqSeq=" + reqSeq +
                ", reqSign='" + reqSign + '\'' +
                ", reqTime=" + reqTime +
                ", reqVer=" + reqVer +
                ", optToken='" + optToken + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getReqSeq() {
        return reqSeq;
    }

    public void setReqSeq(Long reqSeq) {
        this.reqSeq = reqSeq;
    }

    public String getReqSign() {
        return reqSign;
    }

    public void setReqSign(String reqSign) {
        this.reqSign = reqSign;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public Integer getReqVer() {
        return reqVer;
    }

    public void setReqVer(Integer reqVer) {
        this.reqVer = reqVer;
    }

    public String getOptToken() {
        return optToken;
    }

    public void setOptToken(String optToken) {
        this.optToken = optToken;
    }
}

package cn.huanju.edu100.hqwx.usercenter.model.usercenter;

import java.io.Serializable;

/**
 * @Description: UC请求中业务相关的Data基础数据
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-20
 */
public class BizBaseData implements Serializable {
    //前端业务模块定义
    private String appId;

    //前端平台终端定义
    private String platform;

    @Override
    public String toString() {
        return "QueryBaseData{" +
                "appId='" + appId + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}

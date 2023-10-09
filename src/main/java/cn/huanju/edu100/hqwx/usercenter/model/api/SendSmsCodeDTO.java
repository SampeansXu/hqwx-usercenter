package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;

/**
 * @Description: 发短信 反馈
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-09-29
 */
public class SendSmsCodeDTO implements Serializable {
    private Long expriceTime;

    @Override
    public String toString() {
        return "SendSmsCodeDTO{" +
                "expriceTime=" + expriceTime +
                '}';
    }

    public Long getExpriceTime() {
        return expriceTime;
    }

    public void setExpriceTime(Long expriceTime) {
        this.expriceTime = expriceTime;
    }
}

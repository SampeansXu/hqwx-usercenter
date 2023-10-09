package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: ThirdLoginMsgInfoDTO
 * @Author: xushengbin@hqwx.com
 * @Date: 2023-01-16
 * @Ver: v1.0 -create
 */
public class ThirdLoginMsgInfoDTO implements Serializable {
    private String msg;
    private String msgID;
    private List<Map<String, String>> msgOpt;
    private Map<String, String> msgParam;

    public ThirdLoginMsgInfoDTO() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public List<Map<String, String>> getMsgOpt() {
        return msgOpt;
    }

    public void setMsgOpt(List<Map<String, String>> msgOpt) {
        this.msgOpt = msgOpt;
    }

    public Map<String, String> getMsgParam() {
        return msgParam;
    }

    public void setMsgParam(Map<String, String> msgParam) {
        this.msgParam = msgParam;
    }
}

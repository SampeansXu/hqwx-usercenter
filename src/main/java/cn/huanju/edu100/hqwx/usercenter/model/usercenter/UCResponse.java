package cn.huanju.edu100.hqwx.usercenter.model.usercenter;


import java.io.Serializable;
import java.util.Map;

/**
 * @Description: 用户中心 返回基础数据
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-04
 */
public class UCResponse implements Serializable {
    //返回码,INT类型的数据
    private Integer rCode;

    //返回信息
    private String rMsg;

    //数据, JSON 结构
    private Map<String, Object> data;

    //内部错误标识, 但是不影响返回给用户的结果
    private Integer rAddCode;
    private String rAddMsg;

    //与请求中的数据保持一致
    private Long reqSeq;

    //数据签名信息
    private String ResSign;

    //服务器时间Unix秒数
    private Long resTime;

    //可选参数,附加一些错误信息
    private String addMsg;

    private String addRetCode;

    private Integer rHttpCode;

    private Integer rMysqlCode;

    public boolean isOk(){
        if(rCode!=null){
            return rCode.equals(1);
        }
        return false;
    }

    @Override
    public String toString() {
        return "UCResponse{" +
                "rCode=" + rCode +
                ", rMsg='" + rMsg + '\'' +
                ", data=" + data +
                ", rAddCode=" + rAddCode +
                ", rAddMsg='" + rAddMsg + '\'' +
                ", reqSeq=" + reqSeq +
                ", ResSign='" + ResSign + '\'' +
                ", resTime=" + resTime +
                ", addMsg='" + addMsg + '\'' +
                ", addRetCode='" + addRetCode + '\'' +
                ", rHttpCode=" + rHttpCode +
                ", rMysqlCode=" + rMysqlCode +
                '}';
    }

    public Integer getrCode() {
        return rCode;
    }

    public void setrCode(Integer rCode) {
        this.rCode = rCode;
    }

    public String getrMsg() {
        return rMsg;
    }

    public void setrMsg(String rMsg) {
        this.rMsg = rMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Integer getrAddCode() {
        return rAddCode;
    }

    public void setrAddCode(Integer rAddCode) {
        this.rAddCode = rAddCode;
    }

    public String getrAddMsg() {
        return rAddMsg;
    }

    public void setrAddMsg(String rAddMsg) {
        this.rAddMsg = rAddMsg;
    }

    public Long getReqSeq() {
        return reqSeq;
    }

    public void setReqSeq(Long reqSeq) {
        this.reqSeq = reqSeq;
    }

    public String getResSign() {
        return ResSign;
    }

    public void setResSign(String ResSign) {
        this.ResSign = ResSign;
    }

    public Long getResTime() {
        return resTime;
    }

    public void setResTime(Long resTime) {
        this.resTime = resTime;
    }

    public String getAddMsg() {
        return addMsg;
    }

    public void setAddMsg(String addMsg) {
        this.addMsg = addMsg;
    }

    public String getAddRetCode() {
        return addRetCode;
    }

    public void setAddRetCode(String addRetCode) {
        this.addRetCode = addRetCode;
    }

    public Integer getrHttpCode() {
        return rHttpCode;
    }

    public void setrHttpCode(Integer rHttpCode) {
        this.rHttpCode = rHttpCode;
    }

    public Integer getrMysqlCode() {
        return rMysqlCode;
    }

    public void setrMysqlCode(Integer rMysqlCode) {
        this.rMysqlCode = rMysqlCode;
    }
}

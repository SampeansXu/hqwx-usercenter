package cn.huanju.edu100.hqwx.usercenter.model.api;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: 反馈结果
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-08-03
 */
public class HQUCResponse<T> implements Serializable {

    interface CodeVal {
        Integer Ok = 0;
        Integer Error = -1;
    }

    private Integer code = CodeVal.Ok;
    private String msg;
    private T data;

    public static <T> HQUCResponse<T> Ok(T data) {
        return new HQUCResponse(CodeVal.Ok, null, data);
    }

    public static <T> HQUCResponse<T> Error(String msg) {
        return new HQUCResponse(CodeVal.Error, msg, null);
    }

    public static <T> HQUCResponse<T> Error(String msg, T data) {
        return new HQUCResponse(CodeVal.Error, msg, data);
    }

    public static <T> HQUCResponse<T> response(Integer code, String msg) {
        return new HQUCResponse(code, msg, null);
    }

    public static <T> HQUCResponse<T> response(Integer code, String msg, T data) {
        return new HQUCResponse(code, msg, data);
    }

    public boolean isOk() {
        if (Objects.nonNull(code) && code.equals(CodeVal.Ok)) {
            return true;
        }

        return false;
    }

    private HQUCResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "HQUCResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}

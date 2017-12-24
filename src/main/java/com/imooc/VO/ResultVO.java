package com.imooc.VO;

/**
 * Created by hh on 2017/9/13.
 */

/**
 * http请求返回的最外层对象
 */
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

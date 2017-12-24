package com.imooc.enums;

/**
 * Created by hh on 2017/9/14.
 */
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

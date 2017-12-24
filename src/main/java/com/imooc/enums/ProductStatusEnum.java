package com.imooc.enums;

/**
 * 商品状态
 * Created by hh on 2017/9/13.
 */
public enum  ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message ) {
        this.message = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

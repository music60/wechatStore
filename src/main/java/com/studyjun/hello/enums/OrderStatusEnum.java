package com.studyjun.hello.enums;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum {

    NEW(0,"新增订单"),
    FINISHED(1,"完成订单"),
    CANCEL(2,"取消订单");


    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

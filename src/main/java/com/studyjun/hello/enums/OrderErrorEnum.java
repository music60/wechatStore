package com.studyjun.hello.enums;

import lombok.Getter;

@Getter
public enum  OrderErrorEnum {

    PROUDCT_NO_EXIST(1,"商品不存在"),
    OUT_OF_STOCK(2,"超出库存");


    private int code;

    private String message;

    OrderErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

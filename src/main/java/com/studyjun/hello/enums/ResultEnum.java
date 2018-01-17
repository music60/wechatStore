package com.studyjun.hello.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NO_EXIST(1,"商品不存在"), PRODUCT_STOCK_ERROR(20, "商品库存有误");

    private int code;

    private String message;

    ResultEnum(int code,String message){
        this.code=code;
        this.message=message;
    }

}

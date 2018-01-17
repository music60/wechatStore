package com.studyjun.hello.exception;

import com.studyjun.hello.enums.ResultEnum;

public class SellException extends RuntimeException {

    private int code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

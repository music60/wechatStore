package com.studyjun.hello.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private int code;
    private String message;

    private T data;





}

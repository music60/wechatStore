package com.studyjun.hello.util;

import com.studyjun.hello.vo.ResultVo;

public class ResultUtils {

    public  static ResultVo onSuccess(){
        return onSuccess(null);
    }

    public static ResultVo onSuccess(Object data){
        ResultVo vo = new ResultVo();
        vo.setCode(0);
        vo.setMessage("success");
        vo.setData(data);
        return vo;
    }

    public static ResultVo onError(){
        return onError("错误");
    }

    public static ResultVo onError(int code ,String messsage,Object data){
        ResultVo vo = new ResultVo();
        vo.setCode(code);
        vo.setMessage(messsage);
        vo.setData(data);
        return vo;
    }


    public static ResultVo onError(int code ,String messsage){

        return onError(code,messsage,null);
    }

    public static ResultVo onError(String messsage){

        return onError(1,messsage,null);
    }
}

package com.studyjun.hello.util;

import java.util.Random;

public class KeyUtils {


    /***
     * Id 生成器
     * @return
     */
    public  static  synchronized String getgenerateKey(){
        int random = new Random().nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(random);

    }

}

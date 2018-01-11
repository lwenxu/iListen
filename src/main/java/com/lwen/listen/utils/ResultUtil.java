package com.lwen.listen.utils;


import com.lwen.listen.entity.Result;

public class ResultUtil {

    public static Result success(int code, String msg, Object data){
        return new Result(code, msg, data);
    }
}

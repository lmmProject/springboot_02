package com.lmm.utils;

import com.lmm.domain.Result;

/**
 * 重构：返回结果
 * Created by lmm on 2018/5/6.
 */
public class ResultUtil {
    public static Result sucess(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result sucess(){
        return sucess(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

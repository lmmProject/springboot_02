package com.lmm.utils;

import com.lmm.domain.Result;
import com.lmm.enums.ResultEnum;

import static com.lmm.enums.ResultEnum.SUCCESS;

/**
 * 重构：返回结果
 * Created by lmm on 2018/5/6.
 */
public class ResultUtil {

    @SuppressWarnings("unchecked")
    public static Result sucess(Object obj){
        Result result = new Result();
        result.setCode(SUCCESS.getCode());
        result.setMsg(SUCCESS.getMsg());
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

    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }
}

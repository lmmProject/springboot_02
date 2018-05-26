package com.lmm.exception;

import com.lmm.enums.ResultEnum;

/**
 *  自定义异常，用来抛出使用
 * Created by lmm on 2018/5/26.
 */
public class GirlException extends RuntimeException {

    private  Integer code;

//    public GirlException(Integer code, String message){
//        super(message);
//        this.code = code;
//    }

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

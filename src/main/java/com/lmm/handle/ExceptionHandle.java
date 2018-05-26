package com.lmm.handle;

import com.lmm.domain.Result;
import com.lmm.enums.ResultEnum;
import com.lmm.exception.GirlException;
import com.lmm.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *  异常处理类，规范返回给浏览器异常的格式
 *
 *   @ControllerAdvice + @ExceptionHandler
 *  优点：将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
 *  缺点：只能处理 Controller 层未捕获（往外抛）的异常，
 *  对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
 *
 * Created by lmm on 2018/5/26.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), e.getMessage());
        }else {
            logger.error("【系统错误】{}", e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }
}

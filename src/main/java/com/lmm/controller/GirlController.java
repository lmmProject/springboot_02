package com.lmm.controller;

import com.lmm.domain.Girl;
import com.lmm.domain.Result;
import com.lmm.repository.GirlRepository;
import com.lmm.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lmm on 2018/4/23.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value="/getGirls")
    public List<Girl> getGirls(){
        System.out.println(this.getClass().getName()+":"+new Exception().getStackTrace()[0].getMethodName());
        return girlRepository.findAll();
    }
    //对于异常处理的代码，已经重复。需要即刻重构
//    @PostMapping(value = "/addGirl")
//    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
//        Result<Girl> result = new Result<>();
//        if (bindingResult.hasErrors()){
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
//        }
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlRepository.save(girl));
//        return result;
//    }

    @PostMapping(value = "/addGirl")
    public Result addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.sucess(girlRepository.save(girl));
    }
}

package com.lmm.service;

import com.lmm.domain.Girl;
import com.lmm.enums.ResultEnum;
import com.lmm.exception.GirlException;
import com.lmm.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service处理异常，往外层抛
 *
 * Createdby lmm on 2018/5/26.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     *  想当于表单的校验
     */
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            //返回 “你还在上小学吧”, code 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age >= 10 && age < 16){
            //返回“你可能在上初中”, code 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        //执行其它的业务逻辑操作，不想前面被return 结束

        //加钱
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}

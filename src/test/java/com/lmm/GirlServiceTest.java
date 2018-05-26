package com.lmm;

import com.lmm.domain.Girl;
import com.lmm.exception.GirlException;
import com.lmm.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  Service层测试
 * Created by lmm on 2018/5/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getAgeTest(){
        Girl girl = girlService.findOne(11);
        Assert.assertEquals(new Integer(14), girl.getAge());
    }

}

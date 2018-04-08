package com.imooc.girl;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.service.GirlService04;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GirlService单元测试
 *
 * 对Girl项目进行Service测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService04 girlService;

    @Test
    public void findOneTest() {

        Girl girl = girlService.findOne(73);

    }


}

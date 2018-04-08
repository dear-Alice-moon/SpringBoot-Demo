package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GirlException02;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService04 {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional  // 事物注解 ---》 只有事物中所有的语句执行正确，各个数据才能进行提交。否则事物会回滚。
    public  void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(22);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 10) {
            // 返回"你还在上小学"  code = 100
            throw new GirlException02(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            // 返回"你可能在上初中"  code = 101
            throw new GirlException02(ResultEnum.MIDDLE_SCHOOL);
        }

        // 如果 >16岁， 加钱。
        // ...

    }  // public void getAge(Integer id)


    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }


}

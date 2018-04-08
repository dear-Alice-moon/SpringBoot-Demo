package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

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

    public Integer getAge(Integer id) {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 10) {
            // 返回"你还在上小学"
            return 1;
        } else if (age > 10 && age < 16) {
            // 返回"你可能在上初中"
            return 2;
        }

        return  0;
    }  // public void getAge(Integer id)


}

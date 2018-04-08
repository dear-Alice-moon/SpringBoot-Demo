package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @Author Rk
 */
// @SpringBootApplication
// @ComponentScan(value = {"com.liu.config","com.liu.controller","com.liu.service"})
@RestController
@RequestMapping("/girlCon02")
public class GirlController02 {

    private final static Logger logger = LoggerFactory.getLogger(GirlController02.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList () {

        logger.info("girlList");

        System.out.printf("这是一个测试！！！");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生  ---》 前台使用POST 方法
     * @return
     */
    @PostMapping(value = "/girls")  // 使用PostMapping()注解
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.print(bindingResult.getFieldError().getDefaultMessage());
            // System.out.printf("");

            return null;
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }

    // 查询一个女生  ---》 前台使用 Get方法
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {

        // return  "123";
        //return new Girl(7,"B", 27);
        return girlRepository.findOne(id);
    }

    // 更新信息  ---》 前台使用PUT 方法
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        // Girl girl1 = new Girl(id, cupSize, age);  // 以上四行代码等同于本行代码

        return girlRepository.save(girl); // 根据主键更新

    }


    // 删除 ---》 前台使用Delete 方法
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    // 通过年龄查询女生列表  ---》 需要在接口中进行扩展
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age ) {

        return  girlRepository.findByAge(age);
    }

    // 同时插入2条数据
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

}

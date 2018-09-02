package com.xiao.test;

import com.alibaba.fastjson.JSON;
import com.xiao.user.dao.mapper.UserMapper;
import com.xiao.user.dao.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/2 9:33
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setPhone("18717353587");
        user.setUsername("xiao");
        user.setPassword("123");
        int insert = userMapper.insert(user);
        log.info("{}", insert);
    }

    @Test
    public void findAll() {
        List<User> all = userMapper.findAll();
        System.out.println(JSON.toJSONString(all));
    }

    @Test
    public void findById() {
        User user = userMapper.findById(1L);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void update() {
        User user = userMapper.findById(1L);
        user.setPhone("17628292931");
        userMapper.update(user);
    }

}

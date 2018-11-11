package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/10/9 0009.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void insert(){
        User user = new User();
        user.setId(3L);
        user.setName("哈111哈");
        user.setAge(20);
        user.setEmail("zf1017@foxmail");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void delete(){
        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }

    @Test
    public void update(){
        User user = userMapper.selectById(2L);
        user.setName("hehe");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void select(){
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    public void page(){
        IPage<User> userIPage = userMapper.selectPage(new Page<>(0,2),new QueryWrapper<>());
        System.out.println(userIPage.getRecords().toString());
    }

    @Test
    public void selectBy(){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", "hehe"));
        System.out.println(user.toString());
    }
}
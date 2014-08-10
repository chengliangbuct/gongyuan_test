package com.alibaba.gongyuan;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.gongyuan.entity.User;
import com.alibaba.gongyuan.runner.JUnit4ClassLog4jRunner;
import com.alibaba.gongyuan.service.UserService;

import org.apache.log4j.Logger;  

@RunWith(JUnit4ClassLog4jRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class test {
    
    private static Logger logger = Logger.getLogger(test.class);
    
    @Autowired UserService userService ;
    
    
    
    @Test
    public void countAll(){
        logger.info("数据库中的记录条数:"  + userService.countAll());
        //System.out.println("数据库中的记录条数:"  + userService.countAll());
    }
    
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("苏若年");
        user.setPassword("passtest");
        user.setEmail("dennisit@163.com");
        user.setSex("男");
        user.setAge(23);
        userService.insert(user);
    }
    
    @Test
    public void selectAll(){
        List<User> list = userService.selectAll();
        for(int i=0; i<list.size(); i++){
            User user = list.get(i);
            System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());
        }
    }
    
    @Test
    public void update(){
        User user = new User();
        user.setUsername("苏若年");
        user.setPassword("xxxxxxxx");
        user.setEmail("xxxxxx@163xxx");
        user.setSex("男");
        user.setAge(23);
        userService.update(user);
    }
    
    @Test
    public void delete(){
        userService.delete("苏若年");
    }
    
    @Test
    public void findByName(){
        User user = userService.findByUserName("苏若年");
        System.out.println("用户名:" + user.getUsername() + "\t密码:" + user.getPassword() + "\t邮箱：" + user.getEmail());

    }
}
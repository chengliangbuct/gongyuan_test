package com.alibaba.gongyuan.dao;

import java.util.List;
import com.alibaba.gongyuan.entity.User;



public interface UserDao {

    public int insert(User user);
     
    public int update(User user);
   
    public int delete(String userName);
   
    public List<User> selectAll();
   
    public int countAll();
   
    public User findByUserName(String userName);

}
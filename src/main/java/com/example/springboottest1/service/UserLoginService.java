package com.example.springboottest1.service;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLoginService {

    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper;

//boolean返回值只要true或false
   public List<User> findByName(String username){
       return usermapper.findByName(username);
   }
   //根据用户名得到id
    public int getIdByUserName(String username){
       return usermapper.getIdByUserName(username);
    }
    //用户登录
    public User userLogin(String username, String password){
        return usermapper.userlogin(username,password);
    }

    //注册新用户
    public int adduser(String username,String password){

        /**
         * 注意查看mapper中的注释
         */
      return usermapper.adduser(username,password);
       //return usermapper.adduser1(username,password);     //对应sql语句中的第二种注册方式
    }

    //查询用户列表
    public List<Map<String,Object>> queryAllUser(){
        return usermapper.queryAllUser();
    }
}

package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
//@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {

    //用户验证
    @Select("select * from user where username=#{username}")
     public User findUserByUserName(String username);

    //得到用户id
    @Select("select roleid  from user where username=#{username}")
    public int getIdByUserName(String username);

    //用户登录
    User userlogin(@Param("username") String username,@Param("password") String password);
    /**
     * 在这里写了两种新建用户的方式(具体查看sql语句)：
     *     1、id自增：即id每次加1这种
     *     2、利用UUID()生成id，在存入用户
     * 若采用第1种方式，需要对数据库中的id字段做一些修改，将id的类型改为int型，同时定义为可以自增。
     * 若采用第2种方式，则将将id的类型改为varchar型，同时取消自增。
     *
     * 无论再用那种方式，都需要注意实体类中的类型是否与数据库一致，若不一致，项目运行时报错。
     */
    //注册新用户(方式1)
    int adduser(@Param("username") String username, @Param("password") String password);

    //注册新用户（方式2）
    int adduser1(@Param("username") String username, @Param("password") String password);

    /*
    这是mybatis注解版
     */
    //按id查询
    @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    //按id删除
    @Delete("delete * from user where id=#{id}")
    public int deleteUserById(Integer id);

    //插入数剧,可用于用户注册
    @Options(useGeneratedKeys = true,keyProperty = "")//自增主键自动添加
    @Insert("insert into user (username,password) values (#{username},#{password})")
    public int insertUser(User username,User password);

    //更新数据
    @Update("update user set username=#{username} and password=#{password} where id=#{id}")
    public int updateUser(User username,User password);

    //查询用户名
    @Select({"select * from user where username=#{username}"})
    List<User> findByName(@Param("username") String username);

    //查询用户列表
    List<Map<String,Object>> queryAllUser();

}
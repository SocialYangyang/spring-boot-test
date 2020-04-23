package com.example.springboottest1.entity;


import javax.persistence.*;

/*
用户实体类
 */
@Entity//告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "user")//数据表名；如果省略就是默认类名小写
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    //@GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id",length = 16)//这是和数据表对应的一个列
    private Integer id;
    @Column//省略，默认列名就是属性名
    private String username;

    private String password;

//    @Enumerated(EnumType.STRING)
    private Integer roleid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

//    //配置决算角色有admin,student
//    public enum Role{
//        admin,student
//    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

}
package com.example.springboottest1.entity;

import javax.persistence.*;
import java.io.Serializable;

//@Entity//告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "bm_user")//数据表名；如果省略就是默认类名小写
public class Student implements Serializable {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    //@GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id")//这是和数据表对应的一个列
    private Integer id;
    //学号
    private String sno;
    //姓名
    private String username;
    //邮箱
    private String email;
    //性别1为男,0为女
    private String gender;
    //专业id
    private Professional professional;
    private Integer pid;
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }



    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    //年级
    private String grade;
    //兴趣爱好
    private String  hobby;
    //参加数学建模的原因
    private String why;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String  getSno() {
        return  sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String  getUsername() {
        return  username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String  getGrade() {
        return  grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String  getHobby() {
        return  hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String  getWhy() {
        return  why;
    }
    public void setWhy(String why) {
        this.why = why;
    }
    //    //必须要有构造函数
    public Student(){

    }
   public Student (Integer id,String sno,String username,String email,String gender,Integer pid, String grade, String hobby, String why){
        super();
        this.id = id;
        this.sno = sno;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.pid = pid;
        this.grade = grade;
        this.hobby = hobby;
        this.why = why;
    }
    @Override
    public String toString() {
        return  "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", pid='" + pid + '\'' +
                ", grade='" + grade + '\'' +
                ", hobby='" + hobby + '\'' +
                ", why='" + why + '\'' +
                '}';
    }
}
package com.example.springboottest1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;


@Table(name = "pro_name")//数据表名；如果省略就是默认类名小写
public class Professional implements Serializable {
    @Id//这是一个主键
    private  Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private  String proname;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Professional(){

    }
    public Professional(int pid,String proname){
        this.pid = pid;
        this.proname = proname;
    }


    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    @Override
    public String toString(){
        return "Professional [pid=" + pid+ ", proname=" + proname + "]";
    }
}

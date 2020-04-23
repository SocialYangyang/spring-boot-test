package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Student;
import com.example.springboottest1.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/student")
    public String addEmp(Student student, Map<String ,Object> map){
        System.out.println("保存的同学信息"+student);
        //保存报名信息
        studentMapper.insertStudent(student);
        //来到培训人员列表页面
        //redirect 重定向,  /代表当前项目路径
        //学生报名成功来到首页
        map.put("msg","您已报名成功，请等待通知！");
        return "redirect:/index.html";
    }
}

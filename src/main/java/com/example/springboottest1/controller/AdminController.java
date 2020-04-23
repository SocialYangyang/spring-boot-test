package com.example.springboottest1.controller;


import com.example.springboottest1.entity.Professional;
import com.example.springboottest1.entity.Student;
import com.example.springboottest1.mapper.ProfessionalMapper;
import com.example.springboottest1.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ProfessionalMapper professionalMapper;

    //根据id进行查询
    @GetMapping("/stu/{id}")
    public Student getStu(@PathVariable("id") Integer id){

    return studentMapper.getStuById(id);
    }

    //查询所有同学信息，返回到列表页面
    @GetMapping("/emps")
    public String list( Model model){
        //查出Stu类里的数据，存入model中
            List<Student> students = studentMapper.findAll();
//            for (Stu stu : stus){
//                System.out.println(stu);
//                System.out.println(stu.getPid());
//            }
            model.addAttribute("emps",students);
//            //查出Professional类的数据，存入model中
//            Collection<Professional> professionals = professionalMapper.findAll();
//            model.addAttribute("pro",professionals);
        //thymeleaf默认会拼串
        return "emp/list";
    }

    //来到培训添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到培训报名界面，查出所有专业，在页面显示
        Collection<Professional> professionals = professionalMapper.findAll();
        model.addAttribute("pros",professionals);
        //来到add.html页面
        return "emp/add";
    }

    //培训报名
//(Stu stu)自动请求参数和入参对象的值，进行一一绑定，要求请求参数的名字和javaBean
    //入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Student student){
        System.out.println("保存的同学信息"+student);
        //保存报名信息
        studentMapper.insertStudent(student);
        //来到培训人员列表页面
        //redirect 重定向,  /代表当前项目路径
        return "redirect:/emps";
    }

}

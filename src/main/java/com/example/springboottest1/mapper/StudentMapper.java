package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
//@Mapper指定这是一个操作数据库的mapper
public interface StudentMapper {


        @Select("select * from bm_user where id=#{id}")
        public Student getStuById(Integer id);

        //根据id删除学生
        @Delete("delete  from bm_user where id=#{id}")
        public int deleteDeptById(Integer id);

        //插入操作
        @Insert("insert into bm_user (sno,username,email,gender,pid,grade,hobby,why) " +
                "values(#{sno},#{username},#{email},#{gender},#{pid},#{grade},#{hobby},#{why})")
        public int insertStudent(Student student);

        //更新操作
        @Update("update bm_user set son=#{son},username=#{username},email=#{email}," +
                "gender=#{gender},pid=#{pid},grade=#{grade},hobby=#{hobby},,why=#{why},")
        public int updateStudent(Student student);
        /*
        查询所有学生
         */
        List<Student> findAll();
}

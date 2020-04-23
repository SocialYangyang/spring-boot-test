package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.Professional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
//@Mapper
public interface ProfessionalMapper {

    //查出所有专业
    @Select("select * from pro_name")
    List<Professional> findAll();

    //根据id查出专业
    @Select("select * from pro_name where pid=#{pid}")
    public Professional getProById(Integer pid);
}

package com.example.mapper;
import com.example.bean.UserAddBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserAddMapper {
    void addMapper(String name, String password);
}



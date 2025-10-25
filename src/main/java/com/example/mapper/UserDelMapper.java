package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDelMapper {
    void delMapper(String name, String password);
}



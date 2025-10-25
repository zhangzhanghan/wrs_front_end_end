package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserUpdateMapper {
    void updateMapper(String name, String password);
}



package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NodeInfoAddMapper {
    void nodeInfoAddMapper(String nodeInfo, String relaId);
}



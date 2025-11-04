package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NodeSelfInfoAddMapper {
    void nodeSelfInfoAddMapper(String nodeSelfInfo, String relaId);
}



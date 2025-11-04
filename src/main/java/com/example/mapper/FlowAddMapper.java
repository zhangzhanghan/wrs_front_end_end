package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowAddMapper {
    void flowAddMapper(String flowInfo, String relaId);
}



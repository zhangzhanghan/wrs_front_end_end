package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowUpdateMapper {
    void flowUpdateMapper(String flowAddProcessBeanString, String relaId,String uptTime);
}



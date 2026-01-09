package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FlowAddMapper {
    void flowAddMapper(String flowAddProcessBeanString, String relaId, String crtTime, String uptTime, String flowName);
}



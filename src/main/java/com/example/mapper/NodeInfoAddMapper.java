package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NodeInfoAddMapper {
    void nodeInfoAddMapper(String nodeId, String nodeInfo, String relaId,String crtTime, String uptTime);
}



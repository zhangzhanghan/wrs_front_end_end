package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteMapper {
    void deleteFlowMapper( String relaId);
    void deleteNodeInfoMapper( String relaId);
    void deleteNodeSelfInfoMapper( String relaId);
}

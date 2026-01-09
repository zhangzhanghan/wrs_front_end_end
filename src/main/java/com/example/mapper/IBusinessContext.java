package com.example.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface IBusinessContext {
    boolean setHeadMap(Map val1);
    Map <String, Object> getHeadMap();

    boolean setParamMap(Map val1);
    Map <String, Object> getParamMap();

    boolean setParam(String var1, Object var2);
    <T> T getParam(String var1);
}

package com.example.mapper;
import com.example.bean.SearchFlowByRelaIdBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFlowCrtTimeByRelaIdMapper {
  String searchFlowCrtTimeByRelaIdMapper(String relaId);
}



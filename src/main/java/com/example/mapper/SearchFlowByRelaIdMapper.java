package com.example.mapper;
import com.example.bean.SearchFlowBean;
import com.example.bean.SearchFlowByRelaIdBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFlowByRelaIdMapper {
  List<SearchFlowByRelaIdBean> searchFlowByRelaIdMapper(String  relaId);
  List<SearchFlowByRelaIdBean> searchFlowByRelaIdSelfMapper(String  relaId);
}



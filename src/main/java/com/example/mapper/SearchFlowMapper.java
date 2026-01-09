package com.example.mapper;
import com.example.bean.FlowInfoTable;
import com.example.bean.SearchFlowBean;
import com.example.bean.UserAddBean;
import com.example.response.SearchFlowRes.SearchFlowResFlowInfoRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFlowMapper {
  List<SearchFlowResFlowInfoRes> searchFlowMapper();
}



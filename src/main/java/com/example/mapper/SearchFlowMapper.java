package com.example.mapper;
import com.example.bean.SearchFlowBean;
import com.example.bean.UserAddBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFlowMapper {
  List<SearchFlowBean> searchFlowMapper();
}



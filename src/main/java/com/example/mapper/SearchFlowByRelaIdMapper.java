package com.example.mapper;
import com.example.bean.FlowInfoTable;
import com.example.bean.NodeInfoTable;
import com.example.bean.NodeSelfInfoTable;
import com.example.request.FlowAddRequest.FlowAddProcessBean;
import com.example.bean.SearchFlowByRelaIdBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SearchFlowByRelaIdMapper {
  List<FlowInfoTable> searchFlowByRelaIdFlowInfoMapper(String  relaId);
  List<NodeInfoTable> searchFlowByRelaIdNodeInfoMapper(String  relaId);
  List<NodeSelfInfoTable> searchFlowByRelaIdSelfMapper(String  relaId);
}



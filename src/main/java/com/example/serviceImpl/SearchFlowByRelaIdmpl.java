package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.FlowInfoTable;
import com.example.request.FlowAddRequest.FlowObjectBean;
import com.example.response.SearchFlowByRelaIdRes.SearchFlowByRelaIdResponse;
import com.example.mapper.SearchFlowByRelaIdMapper;
import com.example.response.SearchFlowByRelaIdRes.SearchFlowByRelaIdResFlowInfo;
import com.example.response.SearchFlowByRelaIdRes.SearchFlowByRelaIdResNodeSelfInfo;
import com.example.service.SearchFlowByRelaIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFlowByRelaIdmpl implements SearchFlowByRelaIdService {
    //将DAO注入Service层
    @Autowired
    private SearchFlowByRelaIdMapper searchFlowByRelaIdMapper;

    public SearchFlowByRelaIdResponse searchFlowByRelaIdFunc(String relaId) {

        SearchFlowByRelaIdResponse searchFlowByRelaIdResponse = new SearchFlowByRelaIdResponse(); //总输出
        List<FlowInfoTable> flowInfoTableList = searchFlowByRelaIdMapper.searchFlowByRelaIdFlowInfoMapper(relaId);

        List<SearchFlowByRelaIdResFlowInfo> searchFlowByRelaIdResFlowInfoList = new ArrayList<>();
        List<SearchFlowByRelaIdResNodeSelfInfo> searchFlowByRelaIdResNodeSelfInfoList = new ArrayList<>();
        FlowObjectBean flowObjectBean = new FlowObjectBean();

        for (int i = 0; i < flowInfoTableList.size(); i++) {
            JSONObject jsonObject = JSON.parseObject(flowInfoTableList.get(i).getFlowInfo());
            flowObjectBean = jsonObject.getJSONObject("flowInfo").toJavaObject(FlowObjectBean.class);
            searchFlowByRelaIdResNodeSelfInfoList = (List<SearchFlowByRelaIdResNodeSelfInfo>) jsonObject.get("nodeSelfInfo");
            searchFlowByRelaIdResFlowInfoList = (List<SearchFlowByRelaIdResFlowInfo>) jsonObject.get("edges");
        }

//        for (int i = 0; i < searchFlowByRelaIdResFlowInfoList.size(); i++) {
//            String adc = searchFlowByRelaIdResFlowInfoList.get(i).getId();
//            SearchFlowByRelaIdResNodeSelfInfo searchFlowByRelaIdResNodeSelfInfo = JSON.toJavaObject(jsonObject, SearchFlowByRelaIdResNodeSelfInfo.class);
//        }

        searchFlowByRelaIdResponse.setRelaId(relaId);
        searchFlowByRelaIdResponse.setFlowObject(flowObjectBean);
        searchFlowByRelaIdResponse.setFlowInfo(searchFlowByRelaIdResFlowInfoList); //边界信息


//        List<NodeSelfInfoTable> nodeSelfInfoTableList = searchFlowByRelaIdMapper.searchFlowByRelaIdSelfMapper(relaId);
//        List<SearchFlowByRelaIdResNodeSelfInfo> searchFlowByRelaIdResNodeSelfInfoList = new ArrayList<>();
//        for (int i = 0; i < nodeSelfInfoTableList.size(); i++) {
//            JSONObject jsonObject = JSON.parseObject(nodeSelfInfoTableList.get(i).getNodeSelfInfo());
//            SearchFlowByRelaIdResNodeSelfInfo searchFlowByRelaIdResNodeSelfInfo = JSON.toJavaObject(jsonObject, SearchFlowByRelaIdResNodeSelfInfo.class);
//            searchFlowByRelaIdResNodeSelfInfoList.add(searchFlowByRelaIdResNodeSelfInfo);
//        }

        searchFlowByRelaIdResponse.setNodeSelfInfo(searchFlowByRelaIdResNodeSelfInfoList); //节点和数据信息
        return searchFlowByRelaIdResponse;
    }
}
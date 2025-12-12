package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.example.bean.FlowAddBean;
import com.example.bean.SearchFlowByRelaIdBean;
import com.example.response.SearchFlowByRelaIdBeanResponse;
import com.example.mapper.SearchFlowByRelaIdMapper;
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

    public SearchFlowByRelaIdBeanResponse SearchFlowByRelaIdFunc(String relaId) {
        List<SearchFlowByRelaIdBean> searchFlowByRelaIdBeanList = searchFlowByRelaIdMapper.searchFlowByRelaIdMapper(relaId);
        SearchFlowByRelaIdBeanResponse searchFlowByRelaIdBeanResponse = new SearchFlowByRelaIdBeanResponse();
        searchFlowByRelaIdBeanResponse.setFlowInfo(searchFlowByRelaIdBeanList.get(0).getFlowInfo()); //赋值flowInfo
        searchFlowByRelaIdBeanResponse.setRelaId(searchFlowByRelaIdBeanList.get(0).getRelaId()); //赋值RelaId
        List<FlowAddBean> nodeInfoTmp = new ArrayList<>();
        for (int i = 0; i < searchFlowByRelaIdBeanList.size(); i++) {
            String nodeId = searchFlowByRelaIdBeanList.get(i).getNodeId();
            String nodeInfo = searchFlowByRelaIdBeanList.get(i).getNodeInfo();
            String crtTime = searchFlowByRelaIdBeanList.get(i).getCrtTime();
            String uptTime = searchFlowByRelaIdBeanList.get(i).getUptTime();
            FlowAddBean flowAddBean = new FlowAddBean();
            flowAddBean.setId(nodeId);
            flowAddBean.setValue(nodeInfo);
            flowAddBean.setCrtTime(crtTime);
            flowAddBean.setUptTime(uptTime);
            nodeInfoTmp.add(flowAddBean);
        }
        searchFlowByRelaIdBeanResponse.setNodeInfo(nodeInfoTmp);  // 赋值nodeInfo

        List<SearchFlowByRelaIdBean> searchFlowByRelaIdBeanSelfList = searchFlowByRelaIdMapper.searchFlowByRelaIdSelfMapper(relaId);
        List<String> nodeSelfInfoTmp = new ArrayList<>();
        for (int i = 0; i < searchFlowByRelaIdBeanSelfList.size(); i++) {
            nodeSelfInfoTmp.add(searchFlowByRelaIdBeanSelfList.get(i).getNodeSelfInfo());
        }
        searchFlowByRelaIdBeanResponse.setNodeSelfInfo(nodeSelfInfoTmp);

        return searchFlowByRelaIdBeanResponse;
    }
}
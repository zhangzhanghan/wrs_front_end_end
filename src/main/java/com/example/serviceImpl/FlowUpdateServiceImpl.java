package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.*;
import com.example.request.FlowAddRequest.FlowAddProcessBean;
import com.example.request.FlowAddRequest.FlowInfoBean;
import com.example.request.FlowAddRequest.NodeSelfInfoBean;
import com.example.request.FlowUpdateRequest;
import com.example.service.FlowUpdateService;
import com.example.utils.SerialNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowUpdateServiceImpl implements FlowUpdateService {
    //将DAO注入Service层
    @Autowired
    private FlowUpdateMapper flowUpdateMapper;

    public String flowUpdateFunc(FlowUpdateRequest flowUpdateRequest) {
        try {
            String relaId = flowUpdateRequest.getRelaId();
            SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();
            String uptTime = serialNumberGenerator.getCurrentTime();

            List<FlowInfoBean> flowInfoBeanList = flowUpdateRequest.getFlowInfo();
            List<NodeSelfInfoBean> nodeSelfInfoBeanList = flowUpdateRequest.getNodeSelfInfo();

            for (int i = 0; i < flowInfoBeanList.size(); i++) {
                FlowInfoBean flowInfoBean = flowInfoBeanList.get(i);
                String flowInfoBeanId = flowInfoBean.getId();
                String nodeId = flowInfoBeanId.split("-")[0];
                for (int j = 0; j < nodeSelfInfoBeanList.size(); j++) {
                    if (nodeId.equals(nodeSelfInfoBeanList.get(j).getId())) {
                        flowInfoBean.setType(nodeSelfInfoBeanList.get(j).getType());
                        continue;
                    }
                }
            }

            FlowAddProcessBean flowAddProcessBean = new FlowAddProcessBean();
            flowAddProcessBean.setFlowInfo(flowUpdateRequest.getFlowObject());
            flowAddProcessBean.setEdges(flowInfoBeanList);
            flowAddProcessBean.setNodeSelfInfo(nodeSelfInfoBeanList);

            String flowAddProcessBeanString = JSONObject.toJSONString(flowAddProcessBean);
            flowUpdateMapper.flowUpdateMapper( flowAddProcessBeanString,  relaId, uptTime);

            return "success";
        } catch (Exception e) {
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
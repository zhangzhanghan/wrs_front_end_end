package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.mapper.FlowAddMapper;
import com.example.mapper.NodeInfoAddMapper;
import com.example.mapper.NodeSelfInfoAddMapper;
import com.example.request.FlowAddRequest.*;
import com.example.service.FlowAddService;
import com.example.utils.SerialNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowAddServiceImpl implements FlowAddService {
    //将DAO注入Service层
    @Autowired
    private NodeInfoAddMapper nodeInfoAddMapper;
    @Autowired
    private NodeSelfInfoAddMapper nodeSelfInfoAddMapper;
    @Autowired
    private FlowAddMapper flowAddMapper;

    public String flowAddFunc(FlowAddRequest flowAddRequest) {
        try {
            SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();
            String relaId = serialNumberGenerator.generateSerialNumber();
            String crtTime = serialNumberGenerator.getCurrentTime();
            String uptTime = crtTime;

            List<FlowInfoBean> flowInfoBeanList = flowAddRequest.getFlowInfo();
            List<NodeSelfInfoBean> nodeSelfInfoBeanList = flowAddRequest.getNodeSelfInfo();

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
            String flowName = flowAddRequest.getFlowObject().getEngName();

            FlowAddProcessBean flowAddProcessBean = new FlowAddProcessBean();
            flowAddProcessBean.setFlowInfo(flowAddRequest.getFlowObject());
            flowAddProcessBean.setEdges(flowInfoBeanList);
            flowAddProcessBean.setNodeSelfInfo(nodeSelfInfoBeanList);
//处理流程
            String flowAddProcessBeanString = JSONObject.toJSONString(flowAddProcessBean);
            flowAddMapper.flowAddMapper(flowAddProcessBeanString, relaId, crtTime, uptTime, flowName); //1.新增流程

//            处理节点本身的数据
            for (int i = 0; i < nodeSelfInfoBeanList.size(); i++) {
                String nodeSelfInfo = JSONObject.toJSONString(nodeSelfInfoBeanList.get(i));
                nodeSelfInfoAddMapper.nodeSelfInfoAddMapper(nodeSelfInfo, relaId, crtTime, uptTime); //3.节点本身数据
            }
            return "success";
        } catch (Exception e) {
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
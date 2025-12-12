package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.example.bean.FlowAddBean;
import com.example.mapper.FlowAddMapper;
import com.example.mapper.NodeInfoAddMapper;
import com.example.mapper.NodeSelfInfoAddMapper;
import com.example.request.FlowAddRequest;
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
            String flowInfo = flowAddRequest.getFlowInfo();
            flowAddMapper.flowAddMapper(flowInfo, relaId, crtTime, uptTime); //新增流程
            List<FlowAddBean> nodeInfoList = flowAddRequest.getNodeInfo();
            for (int i = 0; i < nodeInfoList.size(); i++) {
                FlowAddBean flowAddBean = nodeInfoList.get(i);
                String nodeId = flowAddBean.getId();
                String nodeInfo = flowAddBean.getValue();
                nodeInfoAddMapper.nodeInfoAddMapper(nodeId, nodeInfo, relaId, crtTime, uptTime); //节点输入信息
            }
            List<String> NodeSelfInfoList = flowAddRequest.getNodeSelfInfo();
            for (int i = 0; i < NodeSelfInfoList.size(); i++) {
                String nodeSelfInfo = NodeSelfInfoList.get(i);
                nodeSelfInfoAddMapper.nodeSelfInfoAddMapper(nodeSelfInfo, relaId, crtTime, uptTime); //新增流程
            }
            return "success";
        } catch (Exception e) {
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
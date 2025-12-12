package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.mapper.FlowAddMapper;
import com.example.mapper.NodeInfoAddMapper;
import com.example.mapper.NodeSelfInfoAddMapper;
import com.example.request.NodeAddRequest;
import com.example.service.NodeAddService;
import com.example.utils.SerialNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeAddServiceImpl implements NodeAddService {
    //将DAO注入Service层
    @Autowired
    private NodeInfoAddMapper nodeInfoAddMapper;
    @Autowired
    private NodeSelfInfoAddMapper nodeSelfInfoAddMapper;
    @Autowired
    private FlowAddMapper flowAddMapper;

    public String NodeAddFunc(NodeAddRequest nodeAddRequest) {
        try {
            SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();
            String relaId =  serialNumberGenerator.generateSerialNumber();
            String flowInfo = nodeAddRequest.getFlowInfo();
//            flowAddMapper.flowAddMapper(flowInfo,relaId); //新增流程

           List<String> nodeInfoList =  nodeAddRequest.getNodeInfo();
            for (int i = 0; i < nodeInfoList.size(); i++) {
                String nodeInfo = nodeInfoList.get(i);
                String xxx = "79274324";
//                nodeInfoAddMapper.nodeInfoAddMapper(xxx,nodeInfo, relaId); //新增流程
            }
            List<String> NodeSelfInfoList =  nodeAddRequest.getNodeSelfInfo();
            for (int i = 0; i < NodeSelfInfoList.size(); i++) {
                String nodeSelfInfo = NodeSelfInfoList.get(i);
//                nodeSelfInfoAddMapper.nodeSelfInfoAddMapper(nodeSelfInfo, relaId); //新增流程
            }
            return "success";
        } catch (Exception e) {
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
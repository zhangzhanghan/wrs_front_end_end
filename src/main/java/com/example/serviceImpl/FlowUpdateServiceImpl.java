package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.example.bean.FlowAddBean;
import com.example.mapper.*;
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
    private NodeInfoAddMapper nodeInfoAddMapper;
    @Autowired
    private NodeSelfInfoAddMapper nodeSelfInfoAddMapper;
    @Autowired
    private FlowAddMapper flowAddMapper;
    @Autowired
    private DeleteMapper deleteMapper;
    @Autowired
    private SearchFlowCrtTimeByRelaIdMapper searchFlowCrtTimeByRelaIdMapper;

    public String flowUpdateFunc(FlowUpdateRequest flowUpdateRequest) {
        try {
            String relaId = flowUpdateRequest.getRelaId();
            String crtTime = searchFlowCrtTimeByRelaIdMapper.searchFlowCrtTimeByRelaIdMapper(relaId);
            SerialNumberGenerator serialNumberGenerator = new SerialNumberGenerator();
            String uptTime = serialNumberGenerator.getCurrentTime();

            deleteMapper.deleteFlowMapper(relaId);
            deleteMapper.deleteNodeInfoMapper(relaId);
            deleteMapper.deleteNodeSelfInfoMapper(relaId);

            String flowInfo = flowUpdateRequest.getFlowInfo();

            flowAddMapper.flowAddMapper(flowInfo, relaId, crtTime, uptTime); //新增流程
            List<FlowAddBean> nodeInfoList = flowUpdateRequest.getNodeInfo();
            for (int i = 0; i < nodeInfoList.size(); i++) {
                FlowAddBean flowAddBean = nodeInfoList.get(i);
                String nodeId = flowAddBean.getId();
                String nodeInfo = flowAddBean.getValue();
                nodeInfoAddMapper.nodeInfoAddMapper(nodeId, nodeInfo, relaId, crtTime, uptTime); //节点输入信息
            }
            List<String> NodeSelfInfoList = flowUpdateRequest.getNodeSelfInfo();
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
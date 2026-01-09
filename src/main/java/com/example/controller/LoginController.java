package com.example.controller;

import com.example.bean.*;
import com.example.request.FlowAddRequest.FlowAddRequest;
import com.example.request.FlowUpdateRequest;
import com.example.request.NodeAddRequest;
import com.example.request.SearchFlowByRelaIdRequest.SearchFlowByRelaIdRequest;
import com.example.response.SearchFlowByRelaIdRes.SearchFlowByRelaIdResponse;
import com.example.response.SearchFlowRes.SearchFlowResFlowInfoRes;
import com.example.serviceImpl.*;
import com.example.utils.BusinessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    //将Service注入Web层
    @Autowired
    private UserAddServiceImpl UserServiceAddImpl;

    @Autowired
    private UserDelServiceImpl userDelServiceImpl;

    @Autowired
    private UserUpdateServiceImpl userUpdateServiceImpl;

    @Autowired
    private UserSearchServiceImpl UserSearchServiceImpl;

    @Autowired
    private NodeAddServiceImpl nodeAddServiceImpl;

    @Autowired
    private SearchFlowServiceImpl searchFlowServiceImpl;

    @Autowired
    private SearchFlowByRelaIdmpl searchFlowByRelaIdmpl;

    @Autowired
    private FlowAddServiceImpl flowAddServiceImpl;

    @Autowired
    private FlowUpdateServiceImpl flowUpdateServiceImpl;

    @Autowired
    private DealFlowImpl dealFlowImpl;

    //前端调用处理工作流
    @RequestMapping(value = "/dev-api/dealFlow")
    public Map<String, Object> dealFlow(@RequestBody Map<String, Object> request) {
        System.out.println("request" + request);
        BusinessContext ctx = new BusinessContext();
        ctx.setHeadMap((Map)request.get("head"));
        ctx.setParamMap((Map)request.get("body"));

        return dealFlowImpl.dealFlowFunc(ctx);
    }

    // 工作流新增
    @RequestMapping(value = "/dev-api/flowAdd")
    public String flowAdd(@RequestBody FlowAddRequest flowAddRequest) {
        return flowAddServiceImpl.flowAddFunc(flowAddRequest);
    }

    // 工作流更新
    @RequestMapping(value = "/dev-api/flowUpdate")
    public String flowUpdate(@RequestBody FlowUpdateRequest FlowUpdateRequest) {
        return flowUpdateServiceImpl.flowUpdateFunc(FlowUpdateRequest);
    }

    @RequestMapping(value = "/dev-api/add")
    public String loginRequest(@RequestBody NodeAddRequest nodeAddRequest) {
        return nodeAddServiceImpl.nodeAddFunc(nodeAddRequest);
    }

    @RequestMapping(value = "/dev-api/searchFlowService")
    public List<SearchFlowResFlowInfoRes> searchFlowService(@RequestBody String searchFlowServiceRequest) {
        return searchFlowServiceImpl.searchFlowFunc();
    }

    @RequestMapping(value = "/dev-api/SearchFlowByRelaId")
    public SearchFlowByRelaIdResponse SearchFlowByRelaId(@RequestBody SearchFlowByRelaIdRequest searchFlowByRelaIdRequest) {
        String relaId = searchFlowByRelaIdRequest.getRelaId();
        return searchFlowByRelaIdmpl.searchFlowByRelaIdFunc(relaId);
    }

////////////////////////////////////////////////////////
//    @RequestMapping(value = "/dev-api/add")
//    public String loginRequest(@RequestBody UserAddBean userAddRequest) {
//        System.out.println("新增开始"+ userAddRequest);
//        String name = userAddRequest.getName();
//        String password = userAddRequest.getPassword();
//        return UserServiceAddImpl.addFunc(name, password);
//    }
//
//    @RequestMapping(value = "/dev-api/del")
//    public String delRequest(@RequestBody UserAddBean userDelRequest) {
//        System.out.println("删除"+ userDelRequest);
//        String name = userDelRequest.getName();
//        String password = userDelRequest.getPassword();
//        return userDelServiceImpl.delFunc(name, password);
//    }
//
//    @RequestMapping(value = "/dev-api/update")
//    public String updateRequest(@RequestBody UserAddBean userUpdateRequest) {
//        System.out.println("删除"+ userUpdateRequest);
//        String name = userUpdateRequest.getName();
//        String password = userUpdateRequest.getPassword();
//        return userUpdateServiceImpl.updateFunc(name, password);
//    }
//
//    @RequestMapping(value = "/dev-api/search")
//    public List<UserAddBean> searchRequest(@RequestBody UserAddBean userSearchRequest) {
//        System.out.println("查询开始"+ userSearchRequest);
//        String name = userSearchRequest.getName();
//        String password = userSearchRequest.getPassword();
//
//        List<UserAddBean> UserAddBeanRes  = UserSearchServiceImpl.search(name, password);
//        System.out.println("结果"+ UserAddBeanRes);
//        return UserAddBeanRes;
//    }
}

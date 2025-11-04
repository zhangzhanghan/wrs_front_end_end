package com.example.controller;
import com.example.bean.*;
import com.example.request.NodeAddRequest;
import com.example.request.SearchFlowByRelaIdRequest;
import com.example.response.SearchFlowByRelaIdBeanResponse;
import com.example.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/dev-api/add")
    public String loginRequest(@RequestBody NodeAddRequest nodeAddRequest) {
        return nodeAddServiceImpl.NodeAddFunc(nodeAddRequest);
    }
    @RequestMapping(value = "/dev-api/searchFlowService")
    public List<SearchFlowBean> searchFlowService(@RequestBody String searchFlowServiceRequest) {
        return searchFlowServiceImpl.searchFlowFunc();
    }
    @RequestMapping(value = "/dev-api/SearchFlowByRelaId")
    public SearchFlowByRelaIdBeanResponse SearchFlowByRelaId(@RequestBody SearchFlowByRelaIdRequest searchFlowByRelaIdRequest) {
        String relaId = searchFlowByRelaIdRequest.getRelaId();
        return searchFlowByRelaIdmpl.SearchFlowByRelaIdFunc(relaId);
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

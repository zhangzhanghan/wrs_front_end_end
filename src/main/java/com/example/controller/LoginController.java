package com.example.controller;
import com.example.bean.UserAddBean;
import com.example.serviceImpl.UserDelServiceImpl;
import com.example.serviceImpl.UserUpdateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.serviceImpl.UserAddServiceImpl;
import com.example.serviceImpl.UserSearchServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
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

    @RequestMapping(value = "/dev-api/add")
    public String loginRequest(@RequestBody UserAddBean userAddRequest) {
        System.out.println("新增开始"+ userAddRequest);
        String name = userAddRequest.getName();
        String password = userAddRequest.getPassword();
        return UserServiceAddImpl.addFunc(name, password);
    }

    @RequestMapping(value = "/dev-api/del")
    public String delRequest(@RequestBody UserAddBean userDelRequest) {
        System.out.println("删除"+ userDelRequest);
        String name = userDelRequest.getName();
        String password = userDelRequest.getPassword();
        return userDelServiceImpl.delFunc(name, password);
    }

    @RequestMapping(value = "/dev-api/update")
    public String updateRequest(@RequestBody UserAddBean userUpdateRequest) {
        System.out.println("删除"+ userUpdateRequest);
        String name = userUpdateRequest.getName();
        String password = userUpdateRequest.getPassword();
        return userUpdateServiceImpl.updateFunc(name, password);
    }

    @RequestMapping(value = "/dev-api/search")
    public List<UserAddBean> searchRequest(@RequestBody UserAddBean userSearchRequest) {
        System.out.println("查询开始"+ userSearchRequest);
        String name = userSearchRequest.getName();
        String password = userSearchRequest.getPassword();

        List<UserAddBean> UserAddBeanRes  = UserSearchServiceImpl.search(name, password);
        System.out.println("结果"+ UserAddBeanRes);
        return UserAddBeanRes;
    }
}

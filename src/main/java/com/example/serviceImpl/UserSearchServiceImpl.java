package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.bean.UserAddBean;
import com.example.mapper.UserSearchMapper;
import com.example.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {
    //将DAO注入Service层
    @Autowired
    private UserSearchMapper UserSearchMapper;

    @Autowired
    private UserSearchService userSearchService;

    @Override
    public List<UserAddBean> searchFunc(String name, String password) {
        return UserSearchMapper.searchMapper(name, password);
    }
    public  List<UserAddBean> search(String name, String password) {
        List<UserAddBean> userSearchBeanList = userSearchService.searchFunc(name, password);
        System.out.println("查询成功"+ userSearchBeanList);
        if (userSearchBeanList.size() > 0) {
            System.out.println("查询成功");
            return userSearchBeanList;
        } else {
            System.out.println("查询失败");
            return userSearchBeanList;
        }
    }
}
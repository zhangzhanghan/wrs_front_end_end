package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.bean.SearchFlowBean;
import com.example.bean.UserAddBean;
import com.example.mapper.SearchFlowMapper;
import com.example.mapper.UserSearchMapper;
import com.example.service.SearchFlowService;
import com.example.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class SearchFlowServiceImpl implements SearchFlowService {
    //将DAO注入Service层
    @Autowired
    private SearchFlowMapper searchFlowMapper;

    public  List<SearchFlowBean> searchFlowFunc() {
        List<SearchFlowBean> searchFlowBeanList = searchFlowMapper.searchFlowMapper();
        System.out.println("查询成功"+ searchFlowBeanList);
        if (searchFlowBeanList.size() > 0) {
            System.out.println("查询成功");
            return searchFlowBeanList;
        } else {
            System.out.println("查询失败");
            return searchFlowBeanList;
        }
    }
}
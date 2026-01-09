package com.example.service;
import com.example.bean.NodeAddBean;
import com.example.bean.SearchFlowBean;
import com.example.bean.UserAddBean;
import com.example.response.SearchFlowRes.SearchFlowResFlowInfoRes;

import java.util.List;

public interface SearchFlowService {
   List<SearchFlowResFlowInfoRes> searchFlowFunc();
}
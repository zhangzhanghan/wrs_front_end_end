package com.example.service;
import com.example.bean.UserAddBean;

import java.util.List;

public interface UserSearchService {
   List<UserAddBean> searchFunc(String name, String password);
}
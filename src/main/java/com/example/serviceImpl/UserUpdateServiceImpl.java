package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.mapper.UserDelMapper;
import com.example.mapper.UserUpdateMapper;
import com.example.service.UserDelService;
import com.example.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {
    //将DAO注入Service层
    @Autowired
    private UserUpdateMapper userUpdateMapper;

    @Override
    public String updateFunc(String name, String password) {
        try {
            userUpdateMapper.updateMapper(name, password);
            System.out.println("删除成功");
            return "success";
        } catch (Exception e) {
            System.out.println("删除失败"+e.getMessage());
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
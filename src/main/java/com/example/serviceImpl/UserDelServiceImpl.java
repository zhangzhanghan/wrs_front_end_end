package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.mapper.UserAddMapper;
import com.example.mapper.UserDelMapper;
import com.example.service.UserAddService;
import com.example.service.UserDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDelServiceImpl implements UserDelService {
    //将DAO注入Service层
    @Autowired
    private UserDelMapper userAddMapper;

    @Override
    public String delFunc(String name, String password) {
        try {
            userAddMapper.delMapper(name, password);
            System.out.println("删除成功");
            return "success";
        } catch (Exception e) {
            System.out.println("删除失败"+e.getMessage());
            return "fail";
//            throw new RuntimeException(e);
        }
    }
}
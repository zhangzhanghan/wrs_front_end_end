package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑
import com.example.bean.UserAddBean;
import com.example.mapper.UserAddMapper;
import com.example.service.UserAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddServiceImpl implements UserAddService {
    //将DAO注入Service层
    @Autowired
    private UserAddMapper userAddMapper;

//    @Autowired
//    private UserAddService userAddService;
//
//    @Override
//    public void addFunc(String name, String password) {
//        return userAddMapper.addMapper(name, password);
//    }
    public String addFunc(String name, String password) {
        try {
            userAddMapper.addMapper(name, password);
            System.out.println("新增成功");
            return "success";
        } catch (Exception e) {
            System.out.println("新增失败"+e.getMessage());
            return "fail";
//            throw new RuntimeException(e);

        }
//        userAddMapper.addMapper(name, password);
//        System.out.println("新增成功"+ userAddBean);
//        if (userAddBean != null) {
//            System.out.println("新增成功");
//            return "success";
//        } else {
//            System.out.println("新增失败");
//            return "fail";
//        }
    }
}
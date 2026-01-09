package com.example.serviceImpl;
//service层对DAO进行封装，专注于业务逻辑

import com.example.utils.BusinessContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DealFlowImpl {
    public Map<String, Object> dealFlowFunc(BusinessContext ctx) {
        System.out.println("ctx" + ctx);
        Map<String, Object> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
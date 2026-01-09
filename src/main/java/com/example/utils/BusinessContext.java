package com.example.utils;
//service层对DAO进行封装，专注于业务逻辑

import com.example.mapper.IBusinessContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessContext implements IBusinessContext {
    private Map a;
    private Map<String, String> b;
    private Map c;

    public BusinessContext() {
        this(new HashMap());
    }

    public BusinessContext(Map param) {
        this(param, new HashMap());
    }

    public BusinessContext(Map param, Map header) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = param;
        this.b = header;
        this.a.put("head", header);
        this.a.put("body", this.c);
    }

    public boolean setHeadMap(Map map) {
        this.b = map;
        return true;
    }

    public Map getHeadMap() {
        return this.b;
    }

    public boolean setParamMap(Map map) {
        this.c = map;
        return true;
    }

    public Map getParamMap() {
        return this.c;
    }

    public boolean setParam(String name, Object data) {
        this.c.put(name, data);
        return true;
    }

    public <T> T getParam(String xpath) {
        return (T) this.c.get(xpath);
    }
}
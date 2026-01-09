package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class NodeInfoTable {
    private String id;
    private String nodeId;
    private String nodeInfo;
    private String relaId;
    private String crtTime;
    private String uptTime;
}

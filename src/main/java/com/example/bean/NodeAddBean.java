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
public class NodeAddBean {
    private String flowInfo ;
    private List<String> nodeInfo ;
}

package com.example.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class SearchFlowByRelaIdBeanResponse {
    private String flowInfo ;
    private List<String> nodeInfo ;
    private List<String> nodeSelfInfo ;
    private String relaId ;
}

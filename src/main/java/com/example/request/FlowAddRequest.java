package com.example.request;
import com.example.bean.FlowAddBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class FlowAddRequest {
    private String flowInfo ;
    private List<FlowAddBean> nodeInfo ;
    private List<String> nodeSelfInfo ;
}

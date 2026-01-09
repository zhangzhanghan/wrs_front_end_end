package com.example.response.SearchFlowByRelaIdRes;

import com.example.request.FlowAddRequest.NodeInfoValDataBean;
import com.example.request.FlowAddRequest.NodeSelfInfoDataBean;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
public class SearchFlowByRelaIdResNodeSelfInfo {
    private String id;
    private String type;
    private String position;
    private List<NodeInfoValDataBean> inputParams;
    private NodeSelfInfoDataBean data;
}

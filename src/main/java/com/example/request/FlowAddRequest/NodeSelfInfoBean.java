package com.example.request.FlowAddRequest;

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
public class NodeSelfInfoBean {
    private String id;
    private String type;
    private List<NodeInfoValDataBean> inputParams;
    private String position;
    private NodeSelfInfoDataBean data;
}

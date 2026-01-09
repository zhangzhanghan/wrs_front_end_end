package com.example.request.FlowAddRequest;

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
    private FlowObjectBean flowObject;
    private List<FlowInfoBean> flowInfo;
    private List<NodeSelfInfoBean> nodeSelfInfo;
}

package com.example.request.FlowAddRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
public class FlowAddProcessBean {
    private FlowObjectBean flowInfo;
    private List<FlowInfoBean> edges;
    private List<NodeSelfInfoBean> nodeSelfInfo;
}

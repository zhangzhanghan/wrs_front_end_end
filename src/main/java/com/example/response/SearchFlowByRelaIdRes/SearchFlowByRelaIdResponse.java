package com.example.response.SearchFlowByRelaIdRes;
import com.example.request.FlowAddRequest.FlowObjectBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class SearchFlowByRelaIdResponse {
    private String relaId ;
    private FlowObjectBean flowObject;
    private List<SearchFlowByRelaIdResFlowInfo> flowInfo;
    private List<SearchFlowByRelaIdResNodeSelfInfo> nodeSelfInfo;
}

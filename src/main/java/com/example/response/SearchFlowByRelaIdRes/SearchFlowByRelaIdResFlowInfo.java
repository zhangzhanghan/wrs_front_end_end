package com.example.response.SearchFlowByRelaIdRes;

import com.example.request.FlowAddRequest.FlowInfoDataBean;
import lombok.*;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
public class SearchFlowByRelaIdResFlowInfo {
    private String id;
    private String type;
    private String source;
    private String target;
    private String animated;
    private String label;
    private FlowInfoDataBean data;
}


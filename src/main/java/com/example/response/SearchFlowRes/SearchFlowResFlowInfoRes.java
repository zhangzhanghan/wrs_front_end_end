package com.example.response.SearchFlowRes;

import lombok.*;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
public class SearchFlowResFlowInfoRes {
    private String relaId;
    private String flowName;
}


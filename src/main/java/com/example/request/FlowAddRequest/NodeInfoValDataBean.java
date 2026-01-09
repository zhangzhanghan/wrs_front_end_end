package com.example.request.FlowAddRequest;

import lombok.*;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
    public class NodeInfoValDataBean {
    private String rowId ;
    private String chnName ;
    private String engName ;
    private String value ;
}

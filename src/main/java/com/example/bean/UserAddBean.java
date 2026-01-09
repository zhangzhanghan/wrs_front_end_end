package com.example.bean;
import com.example.request.FlowAddRequest.NodeInfoValDataBean;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddBean {
    private int id;
    private String name;
    private String password;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Repository
    @Getter
    @Setter
    @ToString
    public static class NodeInfoBean {
        private String id ;
        private String nodeName ;
        private List<NodeInfoValDataBean> value ;
        private String crtTime ;
        private String uptTime ;
    }
}

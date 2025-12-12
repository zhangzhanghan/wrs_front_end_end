package com.example.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class FlowAddBean {
    private String id ;
    private String value ;
    private String crtTime ;
    private String uptTime ;
}

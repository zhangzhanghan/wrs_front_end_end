package com.example.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class NodeSelfInfoTable {
    private String id ;
    private String nodeSelfInfo ;
    private String relaId ;
    private String crtTime ;
    private String uptTime ;
}

package com.example.bean;
import lombok.*;
import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
@Getter
@Setter
@ToString
public class FlowInfoTable {
    private String id ;
    private String flowInfo ;
    private String relaId ;
    private String crtTime ;
    private String uptTime ;
}

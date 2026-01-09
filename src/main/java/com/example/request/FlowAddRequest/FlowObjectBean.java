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
public class FlowObjectBean {
    private String name;
    private String engName;
    private String description;
}


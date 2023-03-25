package com.kusitms.together.api.service.distance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceDto {

    private String title;
    private String location;
    private String content;
    private LocalDateTime createdDate;

}

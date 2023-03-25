package com.kusitms.together.api.service.distance;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistanceDto {

    private String title;
    private String location;
    private String content;
    private String createdDate;

}

package com.kusitms.together.api.service.distance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRes {
    private String location;
    private List<DistanceDto> nearPosts;
    private List<DistanceDto> AllPosts;
}

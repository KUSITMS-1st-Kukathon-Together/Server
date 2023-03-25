package com.kusitms.together.api.service.distance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainReq {
    private DistanceReq distanceReq;
    private CategoryAndTypeReq categoryAndTypeReq;
}

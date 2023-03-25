package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.service.addr.NaverGeoApi;
import com.kusitms.together.api.domain.post.Category;
import com.kusitms.together.api.domain.post.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DistanceController {

    private final DistanceService distanceService;
    private final NaverGeoApi naverGeoApi;

    @GetMapping("/main")
    public ResponseEntity<PageRes> mainPage(@ModelAttribute MainReq mainReq) throws Exception {

        String addr = naverGeoApi.getAddr(mainReq.getDistanceReq().getLatitude(), mainReq.getDistanceReq().getLongitude());


        List<DistanceDto> nearPosts = distanceService.getNearPosts(mainReq.getDistanceReq().getLatitude(), mainReq.getDistanceReq().getLongitude());
        List<DistanceDto> allPost = distanceService.getAllPost(Category.valueOf(mainReq.getCategoryAndTypeReq().getCategory()), Type.valueOf(mainReq.getCategoryAndTypeReq().getType()));

        return new ResponseEntity<>(new PageRes(addr,nearPosts,allPost), HttpStatus.OK);
    }

}

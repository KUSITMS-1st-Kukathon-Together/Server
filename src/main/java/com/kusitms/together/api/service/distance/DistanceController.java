package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.domain.post.Category;
import com.kusitms.together.api.domain.post.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DistanceController {

    private final DistanceService distanceService;

    @ResponseBody
    @PostMapping("/near")
    public ResponseEntity<List<DistanceDto>> getNearPosts(@RequestBody DistanceReq req) {
        return new ResponseEntity<>(distanceService.getNearPosts(req.getLatitude(), req.getLongitude()), HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/all")
    public ResponseEntity<List<DistanceDto>> getAllPosts(@RequestBody CategoryAndTypeReq CategoryAndTypeReq) {
        return new ResponseEntity<>(distanceService.getAllPost(Category.valueOf(CategoryAndTypeReq.getCategory()), Type.valueOf(CategoryAndTypeReq.getType())), HttpStatus.OK);
    }
}

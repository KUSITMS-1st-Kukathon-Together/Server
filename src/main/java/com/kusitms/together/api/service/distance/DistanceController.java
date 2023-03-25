package com.kusitms.together.api.service.distance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DistanceController {

    private final DistanceService distanceService;

    @PostMapping("/near")
    public ResponseEntity<List<DistanceDto>> getNearPosts(double latitude, double longitude) {
        return new ResponseEntity<>(distanceService.getNearPosts(latitude, longitude), HttpStatus.OK);
    }
}

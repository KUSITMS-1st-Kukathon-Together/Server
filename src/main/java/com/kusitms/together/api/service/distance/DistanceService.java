package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DistanceService {

    private final PostRepository postRepository;

    public List<DistanceDto> getNearPosts(double latitude, double longitude) {
        List<String> postByDistance = postRepository.getPostByDistance(latitude, longitude);
        List<DistanceDto> newDistanceDto = new ArrayList<>();
        for (String s : postByDistance) {
            String[] split = s.split(",");
            newDistanceDto.add(new DistanceDto(split[0], split[1], split[2], split[3]));

        }
        return newDistanceDto;
    }


}

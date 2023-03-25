package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DistanceService {

    private final PostRepository postRepository;

    public List<DistanceDto> getNearPosts(double latitude, double longitude) {
        return postRepository.getPostByDistance(latitude, longitude);
    }


}

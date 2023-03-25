package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.domain.post.Category;
import com.kusitms.together.api.domain.post.PostRepository;
import com.kusitms.together.api.domain.post.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
            LocalDateTime dateTime = LocalDateTime.parse(split[4], formatter);
            newDistanceDto.add(new DistanceDto(Long.parseLong(split[0]), split[1], split[2],split[3], dateTime));

        }
        return newDistanceDto;
    }

    public List<DistanceDto> getAllPost(Category category, Type type) {
        return postRepository.getAllPostByCategoryAndType(category, type);
    }


}

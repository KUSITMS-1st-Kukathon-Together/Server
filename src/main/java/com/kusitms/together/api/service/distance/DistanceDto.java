package com.kusitms.together.api.service.distance;

import com.kusitms.together.api.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceDto {

    private Long id;

    private String title;
    private String location;
    private String content;
    private LocalDateTime createdDate;

    public static DistanceDto from(Post post){
        return new DistanceDto(post.getId(), post.getTitle(), post.getLocation(), post.getContent(), post.getCreatedDate());
    }

}

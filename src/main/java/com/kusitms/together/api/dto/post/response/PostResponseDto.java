package com.kusitms.together.api.dto.post.response;

import com.kusitms.together.api.domain.post.Post;
import com.kusitms.together.api.dto.comment.response.CommentResponseDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String location;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String category;
    private String type;
    private Double latitude;
    private Double longitude;
    private String address;
    private Integer likeCount;
    private Integer commentCount;
    private List<CommentResponseDto> commentList;


    public PostResponseDto(Long id, String title, String content, String location, LocalDateTime createdDate, LocalDateTime modifiedDate, String category, String type, Double latitude, Double longitude, String address, Integer likeCount, Integer commentCount, List<CommentResponseDto> commentList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.location = location;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.category = category;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.commentList = commentList;
    }

    public static PostResponseDto from(Post post, Integer likeCount, Integer commentCount, List<CommentResponseDto> commentList){
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getLocation(), post.getCreatedDate(), post.getModifiedDate(), post.getCategory().toString(), post.getType().toString(), post.getLatitude(), post.getLongitude(), post.getAddress(), likeCount, commentCount, commentList);
    }
}

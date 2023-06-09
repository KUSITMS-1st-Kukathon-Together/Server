package com.kusitms.together.api.domain.post;

import com.kusitms.together.api.domain.comment.Comment;
import com.kusitms.together.api.domain.like.Like;
import com.kusitms.together.api.domain.util.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "OG_POST")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Like> likeList = new ArrayList<>();

    @Builder
    public Post(String location, String title, String content, Category category, Type type, Double latitude, Double longitude, String address) {
        this.location = location;
        this.title = title;
        this.content = content;
        this.category = category;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
}

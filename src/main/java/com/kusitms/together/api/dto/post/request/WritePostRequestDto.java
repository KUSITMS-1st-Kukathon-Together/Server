package com.kusitms.together.api.dto.post.request;

import com.kusitms.together.api.domain.post.Category;
import com.kusitms.together.api.domain.post.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WritePostRequestDto {
    private String title;
    private String content;
    private String location;
    private Category category;
    private Type type;
    private Double latitude;
    private Double longitude;
    private String address;

    
    public WritePostRequestDto(String title, String content, String location, Category category, Type type, Double latitude, Double longitude, String address) {
        this.title = title;
        this.content = content;
        this.location = location;
        this.category = category;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
}

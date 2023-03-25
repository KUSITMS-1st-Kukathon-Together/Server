package com.kusitms.together.api.domain.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

public enum Category {
    공사_및_점검, // 공사 및 점검
    사고_상황, // 사고 상황
    도로_상태, // 도로 상태
    동네_맛집, // 동네 맛집
    같이_해요, // 같이 해요
    취미_생활, // 취미 생활
    일상, // 일상
    기타; // 기타

    @JsonCreator
    public static Category of(String category) {
        for (Category c : Category.values()) {
            if (c.name().equals(category)) {
                return c;
            }
        }
        return null;
    }

}

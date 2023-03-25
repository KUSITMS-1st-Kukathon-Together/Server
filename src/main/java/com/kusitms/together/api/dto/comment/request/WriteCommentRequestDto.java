package com.kusitms.together.api.dto.comment.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteCommentRequestDto {

        private Long parentCommentId;

        private String content;

        @Builder
        public WriteCommentRequestDto(Long parentCommentId, String content) {
            this.parentCommentId = parentCommentId;
            this.content = content;
        }
}

package com.kusitms.together.api.dto.comment.response;

import com.kusitms.together.api.domain.comment.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentResponseDto {

        private Long id;

        private Long memberId;

        private String memberName;

        private String memberProfile;

        private Long parentCommentId;

        private String content;

        private Boolean isChild;

        public CommentResponseDto(Long id, Long memberId, String memberName, String memberProfile, Long parentCommentId, String content, Boolean isChild) {
            this.id = id;
            this.memberId = memberId;
            this.memberName = memberName;
            this.memberProfile = memberProfile;
            this.parentCommentId = parentCommentId;
            this.content = content;
            this.isChild = isChild;
        }

        public static CommentResponseDto from(Comment comment) {
            return new CommentResponseDto(
                    comment.getId(),
                    comment.getMember().getId(),
                    comment.getMember().getNickname(),
                    comment.getMember().getProfileImage(),
                    comment.getParentComment() == null ? null : comment.getParentComment().getId(),
                    comment.getContent(),
                    comment.getIsChild()
            );
        }
}

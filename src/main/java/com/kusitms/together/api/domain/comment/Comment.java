package com.kusitms.together.api.domain.comment;

import com.kusitms.together.api.domain.member.Member;
import com.kusitms.together.api.domain.post.Post;
import com.kusitms.together.api.domain.util.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "OG_COMMENT")
public class Comment extends BaseTimeEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "comment_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "post_id", nullable = false)
        private Post post;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id", nullable = false)
        private Member member;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_comment_id", nullable = false)
        private Comment parentComment;

        @Column(name = "content")
        private String content;

        @Column(name = "is_child")
        private Boolean isChild;

        @Builder
        public Comment(Post post, Member member, Comment parentComment, String content, Boolean isChild) {
                this.post = post;
                this.member = member;
                this.parentComment = parentComment;
                this.content = content;
                this.isChild = isChild;
        }
}

package com.kusitms.together.api.service.comment;

import com.kusitms.together.api.domain.comment.Comment;
import com.kusitms.together.api.domain.comment.CommentRepository;
import com.kusitms.together.api.domain.member.Member;
import com.kusitms.together.api.domain.member.MemberRepository;
import com.kusitms.together.api.domain.post.Post;
import com.kusitms.together.api.domain.post.PostRepository;
import com.kusitms.together.api.dto.comment.request.WriteCommentRequestDto;
import com.kusitms.together.api.dto.comment.response.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final MemberRepository memberRepository;

    private final PostRepository postRepository;

    public CommentResponseDto createComment(Long memberId, Long postId, WriteCommentRequestDto writeCommentRequestDto) {
        Member foundMember = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Post foundPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        Comment foundParentComment = writeCommentRequestDto.getParentCommentId() == null ? null : commentRepository.findById(writeCommentRequestDto.getParentCommentId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        Comment newComment = Comment.builder()
                .post(foundPost)
                .member(foundMember)
                .content(writeCommentRequestDto.getContent())
                .parentComment(foundParentComment)
                .isChild(foundParentComment != null)
                .build();

        commentRepository.save(newComment);

        return CommentResponseDto.from(newComment);
    }

}

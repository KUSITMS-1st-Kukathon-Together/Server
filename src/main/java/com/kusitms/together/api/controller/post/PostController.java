package com.kusitms.together.api.controller.post;

import com.kusitms.together.api.domain.member.MemberAccount;
import com.kusitms.together.api.dto.comment.request.WriteCommentRequestDto;
import com.kusitms.together.api.dto.comment.response.CommentResponseDto;
import com.kusitms.together.api.dto.post.request.WritePostRequestDto;
import com.kusitms.together.api.dto.post.response.PostResponseDto;
import com.kusitms.together.api.service.comment.CommentService;
import com.kusitms.together.api.service.distance.DistanceDto;
import com.kusitms.together.api.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<PostResponseDto> writePost(@AuthenticationPrincipal MemberAccount memberAccount, @RequestBody WritePostRequestDto writePostRequestDto) {
        return ResponseEntity.ok(postService.writePost(memberAccount.getMemberId(), writePostRequestDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<CommentResponseDto> writeComment(@AuthenticationPrincipal MemberAccount memberAccount, @PathVariable Long postId, @RequestBody WriteCommentRequestDto writeCommentRequestDto) {
        return ResponseEntity.ok(commentService.createComment(memberAccount.getMemberId(), postId, writeCommentRequestDto));
    }
}

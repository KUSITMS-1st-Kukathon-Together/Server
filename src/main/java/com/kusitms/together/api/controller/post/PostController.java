package com.kusitms.together.api.controller.post;

import com.kusitms.together.api.domain.member.MemberAccount;
import com.kusitms.together.api.dto.post.request.WritePostRequestDto;
import com.kusitms.together.api.dto.post.response.PostResponseDto;
import com.kusitms.together.api.service.distance.DistanceDto;
import com.kusitms.together.api.service.like.LikeDto;
import com.kusitms.together.api.service.like.LikeReq;
import com.kusitms.together.api.service.like.LikeService;
import com.kusitms.together.api.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<PostResponseDto> writePost(@AuthenticationPrincipal MemberAccount memberAccount, @RequestBody WritePostRequestDto writePostRequestDto) {
        return ResponseEntity.ok(postService.writePost(memberAccount.getMemberId(), writePostRequestDto));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<LikeDto> likePost(@AuthenticationPrincipal MemberAccount memberAccount,@PathVariable Long postId){
        LikeReq likeReq = new LikeReq(postId,memberAccount.getMemberId());
        return new ResponseEntity(likeService.like(likeReq), HttpStatus.OK);
    }
}

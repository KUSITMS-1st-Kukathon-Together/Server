package com.kusitms.together.api.service.like;

import com.kusitms.together.api.domain.like.Like;
import com.kusitms.together.api.domain.like.LikeRepository;
import com.kusitms.together.api.domain.member.MemberRepository;
import com.kusitms.together.api.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public LikeDto like(LikeReq req) {
        Optional<Like> like = likeRepository.findLikeByMember_IdAndPost_Id(req.getUserId(), req.getPostId());
        if (like.isPresent()) { //cancel
            likeRepository.delete(like.get());
            return new LikeDto(like.get().getPost().getId(), like.get().getMember().getId());
        } else {

            Like newLike = new Like(memberRepository.findById(req.getUserId()).get(), postRepository.findById(req.getPostId()).get());
            likeRepository.save(newLike);
            return new LikeDto(newLike.getPost().getId(), newLike.getMember().getId());
        }
    }
}

package com.kusitms.together.api.service.post;


import com.kusitms.together.api.domain.member.Member;
import com.kusitms.together.api.domain.member.MemberRepository;
import com.kusitms.together.api.domain.post.Post;
import com.kusitms.together.api.domain.post.PostRepository;
import com.kusitms.together.api.domain.write.Write;
import com.kusitms.together.api.domain.write.WriteRepository;
import com.kusitms.together.api.dto.post.request.WritePostRequestDto;
import com.kusitms.together.api.dto.post.response.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final MemberRepository memberRepository;

    private final PostRepository postRepository;

    private final WriteRepository writeRepository;
    public PostResponseDto writePost(Long memberId, WritePostRequestDto writePostRequestDto) {
        Member foundMember = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));
        Post post = Post.builder()
                .title(writePostRequestDto.getTitle())
                .content(writePostRequestDto.getContent())
                .location(writePostRequestDto.getLocation())
                .category(writePostRequestDto.getCategory())
                .type(writePostRequestDto.getType())
                .latitude(writePostRequestDto.getLatitude())
                .longitude(writePostRequestDto.getLongitude())
                .address(writePostRequestDto.getAddress())
                .build();

        postRepository.save(post);
        writeRepository.save(Write.builder().post(post).member(foundMember).build());

        return PostResponseDto.from(post);
    }

    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return PostResponseDto.from(post);
    }
}

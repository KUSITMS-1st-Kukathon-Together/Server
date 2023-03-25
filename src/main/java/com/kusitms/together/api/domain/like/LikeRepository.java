package com.kusitms.together.api.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikeByMember_IdAndPost_Id(Long memerId, Long postId);

}

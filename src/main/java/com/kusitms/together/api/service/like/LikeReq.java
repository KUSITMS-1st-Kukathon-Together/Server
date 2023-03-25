package com.kusitms.together.api.service.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeReq {

    private Long postId;
    private Long userId;

}

package com.kusitms.together.api.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "OG_MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "login_id", unique = true, nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "location")
    private String location;

    @Column(name = "profile_img")
    private String profileImage;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String loginId, String password, String nickname, String location, String profileImage, Role role) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.location = location;
        this.profileImage = profileImage;
    }

    public void updateMyLocation(String location){
        this.location = location;
    }
}

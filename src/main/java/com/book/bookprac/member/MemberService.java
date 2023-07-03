package com.book.bookprac.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String signup(SignupRequestDto signupRequestDto) {

        // 저장 하기
        memberRepository.save(Member.builder().
                email(signupRequestDto.getEmail()).
                password(signupRequestDto.getPassword()).
                nickname(signupRequestDto.getNickname()).
                build());
        return "회원가입 성공";
    }


}

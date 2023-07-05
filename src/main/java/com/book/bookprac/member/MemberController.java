package com.book.bookprac.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;


    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SignupRequestDto signupRequestDto, BindingResult result){
        if (result.hasErrors()){
            if (result.getFieldError().getDefaultMessage().equals("패스워드에러"))
                throw new RuntimeException("패스워드 형식이 다릅니다.");
            if (result.getFieldError().getDefaultMessage().equals("닉네임에러"))
                throw new RuntimeException("닉네임 형식이 다릅니다.");
            if (result.getFieldError().getDefaultMessage().equals("이메일에러"))
                throw new RuntimeException("이메일 형식이 다릅니다.");
        }
        return memberService.signup(signupRequestDto);
    }


    @PostMapping("/signup/membercheck")
    public String membercehck(@RequestParam String email) {
        return memberService.membercheck(email);

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        return memberService.login(loginRequestDto);
    }
}

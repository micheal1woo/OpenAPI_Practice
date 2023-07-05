package com.book.bookprac.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class SignupRequestDto {

    @Pattern(regexp = "^[a-zA-Z0-9가-힣_-]{2,20}$", message = "닉네임에러")
    private String nickname;
    @Email(message = "이메일에러")
    private String email;
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\\\d)(?=.*[@$!%*#?&])[A-Za-z\\\\d@$!%*#?&]{8,}$", message = "비밀번호에러")
    private String password;

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

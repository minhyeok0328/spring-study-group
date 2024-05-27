package com.minhyeok.study.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberCreateRequestDto {
    private static final String USERNAME_IS_REQUIRED = "회원 이름을 필수로 입력해야 합니다.";
    private static final String USERNAME_LENGTH = "회원 이름은 2자 이상 16자 이하이어야 합니다.";
    private static final String EMAIL_IS_REQUIRED = "이메일 주소를 필수로 입력해야 합니다.";
    private static final String EMAIL_VALID = "올바른 이메일 주소를 입력해야 합니다.";
    private static final String PASSWORD_IS_REQUIRED = "비밀번호를 필수로 입력해야 합니다.";
    private static final String PASSWORD_LENGTH = "비밀번호는 8자 이상, 24자 이하로 입력해야 합니다.";
    private static final String PASSWORD_PATTERN = "비밀번호는 영문 대소문자 + 숫자를 최소한 하나씩 포함해야 합니다.";

    @NotBlank(message = USERNAME_IS_REQUIRED)
    @Size(min = 2, max = 16, message = USERNAME_LENGTH)
    private String username;

    @NotBlank(message = EMAIL_IS_REQUIRED)
    @Email(message = EMAIL_VALID)
    private String email;

    @NotBlank(message = PASSWORD_IS_REQUIRED)
    @Size(min = 8, max = 24, message = PASSWORD_LENGTH)
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,24}$",
            message = PASSWORD_PATTERN
    )
    private String password;
}

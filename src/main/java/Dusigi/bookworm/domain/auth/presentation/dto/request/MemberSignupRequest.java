package Dusigi.bookworm.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignupRequest {

    @NotBlank(message = "아이디는 null 또는 공백을 허용하지 않습니다.")
    private String id;

    @NotBlank(message = "닉네임은 null 또는 공백을 허용하지 않습니다.")
    private String nickname;

    @NotBlank(message = "패스워드는 null 또는 공백을 허용하지 않습니다.")
    private String password;



}

package Dusigi.bookworm.domain.auth.presentation.dto.request;

import Dusigi.bookworm.domain.auth.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignupRequest {

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;



    public Member convertRequest(){
        return Member.builder()
                .nickname(nickname)
                .password(password)
                .build();
    }
}

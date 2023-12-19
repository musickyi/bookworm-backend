package Dusigi.bookworm.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequest {

    @NotBlank(message = "id 는 필수 입력값입니다.")
    private String memberId;

    @NotBlank(message = "password 는 필수 입력값입니다.")
    private String password;
}

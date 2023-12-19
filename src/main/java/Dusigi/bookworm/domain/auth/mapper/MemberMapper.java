package Dusigi.bookworm.domain.auth.mapper;

import Dusigi.bookworm.domain.auth.entity.Member;
import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberSignupRequest;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {



    public Member signupRequestToMember(MemberSignupRequest request, String password){
        return Member.builder()
                .loginId(request.getId())
                .nickName(request.getNickname())
                .password(password)
                .build();

    }


}

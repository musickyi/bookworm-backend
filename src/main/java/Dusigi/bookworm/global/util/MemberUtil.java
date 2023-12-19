package Dusigi.bookworm.global.util;


import Dusigi.bookworm.domain.auth.entity.Member;
import Dusigi.bookworm.domain.auth.repository.MemberRepository;
import Dusigi.bookworm.global.error.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final MemberRepository memberRepository;

    public String currentNickName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public Member currentMember(){
        return memberRepository.findByNickName(currentNickName())
                .orElseThrow(() -> new GlobalException("member not found", HttpStatus.NOT_FOUND));
    }
}

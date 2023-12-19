package Dusigi.bookworm.global.security.auth;

import Dusigi.bookworm.domain.auth.entity.Member;
import Dusigi.bookworm.domain.auth.repository.MemberRepository;
import Dusigi.bookworm.global.error.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByLoginId(username)
                .orElseThrow(() -> new GlobalException("User Not Found", HttpStatus.NOT_FOUND));

        return new AuthDetails(member);
    }
}

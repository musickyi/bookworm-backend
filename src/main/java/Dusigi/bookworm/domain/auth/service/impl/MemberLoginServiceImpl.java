package Dusigi.bookworm.domain.auth.service.impl;

import Dusigi.bookworm.domain.auth.entity.Member;
import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberLoginRequest;
import Dusigi.bookworm.domain.auth.presentation.dto.response.LoginResponse;
import Dusigi.bookworm.domain.auth.repository.MemberRepository;
import Dusigi.bookworm.domain.auth.service.MemberLoginService;
import Dusigi.bookworm.global.error.GlobalException;
import Dusigi.bookworm.global.security.jwt.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberLoginServiceImpl implements MemberLoginService {

    private final TokenGenerator tokenGenerator;
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Override
    public LoginResponse execute(MemberLoginRequest request) {
        Member member = memberRepository.findMemberByLoginId(request.getMemberId())
                .orElseThrow(() -> new GlobalException("user not found", HttpStatus.NOT_FOUND));

        if (!encoder.matches(request.getPassword(), member.getPassword())) {
            throw new GlobalException("password is invalid", HttpStatus.FORBIDDEN);
        }

        return tokenGenerator.getToken(request.getMemberId());
    }
}

package Dusigi.bookworm.domain.auth.service.impl;

import Dusigi.bookworm.domain.auth.mapper.MemberMapper;
import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberSignupRequest;
import Dusigi.bookworm.domain.auth.repository.MemberRepository;
import Dusigi.bookworm.domain.auth.service.MemberSignUpService;
import Dusigi.bookworm.global.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSignupServiceImpl implements MemberSignUpService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    @Override
    public void execute(MemberSignupRequest request) {
        if(!memberRepository.existsByNickname(request.getNickname()))
            throw new GlobalException("이미 존재하는 닉네임입니다.", HttpStatus.CONFLICT);



        memberRepository.save(memberMapper.signupRequestToMember(request,encoder.encode(request.getPassword())));
    }
}

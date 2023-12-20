package Dusigi.bookworm.domain.auth.service.impl;

import Dusigi.bookworm.domain.auth.presentation.dto.response.TokenResponse;
import Dusigi.bookworm.domain.auth.service.RefreshTokenService;
import Dusigi.bookworm.global.security.jwt.TokenGenerator;
import Dusigi.bookworm.global.security.jwt.TokenParser;
import Dusigi.bookworm.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final TokenParser tokenParser;
    private final JwtProperties jwtProperties;
    private final TokenGenerator tokenGenerator;
    @Override
    public TokenResponse execute(String refreshToken) {
        String nickname = tokenParser.getTokenSubject(refreshToken, jwtProperties.getRefreshSecret());
        return tokenGenerator.getToken(nickname);
    }
}

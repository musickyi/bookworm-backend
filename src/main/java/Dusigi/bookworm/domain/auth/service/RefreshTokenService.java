package Dusigi.bookworm.domain.auth.service;

import Dusigi.bookworm.domain.auth.presentation.dto.response.TokenResponse;

public interface RefreshTokenService {
    TokenResponse execute(String refreshToken);
}

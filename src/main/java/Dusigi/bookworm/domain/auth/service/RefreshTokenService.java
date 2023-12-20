package Dusigi.bookworm.domain.auth.service;

import Dusigi.bookworm.domain.auth.presentation.dto.response.LoginResponse;

public interface RefreshTokenService {
    LoginResponse execute(String refreshToken);
}

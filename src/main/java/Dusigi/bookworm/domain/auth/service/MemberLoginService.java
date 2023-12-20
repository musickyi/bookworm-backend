package Dusigi.bookworm.domain.auth.service;

import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberLoginRequest;
import Dusigi.bookworm.domain.auth.presentation.dto.response.TokenResponse;

public interface MemberLoginService {

    TokenResponse execute(MemberLoginRequest request);
}

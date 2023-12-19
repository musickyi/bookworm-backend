package Dusigi.bookworm.domain.auth.service;

import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberLoginRequest;
import Dusigi.bookworm.domain.auth.presentation.dto.response.LoginResponse;

public interface MemberLoginService {

    LoginResponse execute(MemberLoginRequest request);
}

package Dusigi.bookworm.domain.auth.service;

import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberSignupRequest;

public interface MemberSignUpService {

    public void execute(MemberSignupRequest request);

}

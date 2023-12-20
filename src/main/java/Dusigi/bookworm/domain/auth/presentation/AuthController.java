package Dusigi.bookworm.domain.auth.presentation;

import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberLoginRequest;
import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberSignupRequest;
import Dusigi.bookworm.domain.auth.presentation.dto.response.TokenResponse;
import Dusigi.bookworm.domain.auth.service.MemberLoginService;
import Dusigi.bookworm.domain.auth.service.MemberSignUpService;
import Dusigi.bookworm.domain.auth.service.RefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberSignUpService memberSignUpService;
    private final MemberLoginService memberLoginService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<Void> memberSignup(@RequestBody @Valid MemberSignupRequest request) {
        memberSignUpService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> memberLogin(@RequestBody @Valid MemberLoginRequest request) {
        var response = memberLoginService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/reissue-token")
    public ResponseEntity<TokenResponse> refreshToken(@RequestHeader("RefreshToken") String refreshToken) {
        var response = refreshTokenService.execute(refreshToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package Dusigi.bookworm.domain.auth.presentation;

import Dusigi.bookworm.domain.auth.presentation.dto.request.MemberSignupRequest;
import Dusigi.bookworm.domain.auth.service.MemberSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberSignUpService memberSignUpService;

    @PostMapping("/signup")
    public ResponseEntity<Void> memberSignup(@RequestBody @Valid MemberSignupRequest request){
        memberSignUpService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

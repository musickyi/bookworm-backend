package Dusigi.bookworm.global.security.jwt;

import Dusigi.bookworm.domain.auth.presentation.dto.response.TokenResponse;
import Dusigi.bookworm.global.security.jwt.properties.JwtProperties;
import Dusigi.bookworm.global.security.jwt.properties.TokenTimeProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TokenGenerator {

    private final TokenTimeProperties tokenTimeProperties;
    private final JwtProperties jwtProperties;

    @AllArgsConstructor
    public enum Token {
        ACCESS_TYPE("access"),
        REFRESH_TYPE("refresh"),
        TOKEN_PREFIX("Bearer "),
        AUTHORITY("authority");
        final String value;
    }

    public TokenResponse getToken(String memberId) {
        return TokenResponse.builder()
                .accessToken(generateToken(memberId, Token.ACCESS_TYPE.value, tokenTimeProperties.getAccessTime(), jwtProperties.getAccessSecret()))
                .refreshToken(generateToken(memberId, Token.REFRESH_TYPE.value, tokenTimeProperties.getRefreshTime(), jwtProperties.getRefreshSecret()))
                .accessExpiredAt(accessExpiredTime())
                .refreshExpiredAt(refreshExpiredTime())
                .build();
    }

    private ZonedDateTime accessExpiredTime() {
        return ZonedDateTime.now().plusSeconds(tokenTimeProperties.getAccessTime());
    }

    private ZonedDateTime refreshExpiredTime() {
        return ZonedDateTime.now().plusSeconds(tokenTimeProperties.getRefreshTime());
    }

    private String generateToken(String memberId, String type, long exp, Key secret) {

        final Claims claims = Jwts.claims().setSubject(memberId);

        claims.put("type", type);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .signWith(secret, SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .compact();
    }
}

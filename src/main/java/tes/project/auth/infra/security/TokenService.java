package tes.project.auth.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tes.project.auth.domain.user.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    private final String secret = "secret";

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("tes")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationTime())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException(e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("tes")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    public String getSubject(String tokenJWT) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("tes")
                    .build();

            decodedJWT = verifier.verify(tokenJWT);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT expired or invalid");
        }
    }

    private Instant generateExpirationTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

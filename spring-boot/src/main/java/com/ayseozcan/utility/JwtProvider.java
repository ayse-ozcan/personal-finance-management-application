package com.ayseozcan.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtProvider {
    String audience = "audience";
    String issuer = "financeManagement";

    private final String secretKey = "secretKey";
    private final long exDate = 1000L * 60 * 60;

    public Optional<String> createToken(String id) {
        try {
            String token;
            token = JWT.create().withAudience(audience)
                    .withIssuer(issuer)
                    .withClaim("id", id)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + exDate))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<String> getByIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null)
                return Optional.empty();
            String id = decodedJWT.getClaim("id").asString();
            return Optional.of(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

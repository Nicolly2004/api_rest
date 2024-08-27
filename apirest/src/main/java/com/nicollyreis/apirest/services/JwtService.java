package com.nicollyreis.apirest.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nicollyreis.apirest.models.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

    @Value("60")
    private String expiracao;

    @Value("QXBpUmVzdCBjb20gY3J1ZCBjb21wbGV0byBlIGF1dGVudGljYcOnw6Nv")
    private String chaveAssinatura;

    public  JWTVerifier getVerifier()throws UnsupportedEncodingException {
         return JWT.require(Algorithm.HMAC256(this.chaveAssinatura)).build();
    }
    public String gerarToken(Auth auth) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(this.chaveAssinatura);
        LocalDateTime expiracaoToken = LocalDateTime.now().plusMinutes(Long.valueOf(this.expiracao));
        Date dataExpiracao = Date.from(expiracaoToken.atZone(ZoneId.systemDefault()).toInstant());

        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withExpiresAt(dataExpiracao)
                .withIssuedAt(new Date())
                .withSubject(auth.getId().toString())
                .withClaim("email",auth.getEmail())
                .withClaim("login",auth.getLogin())
                .sign(algorithm);
    }


    public DecodedJWT getClaims(String token) throws UnsupportedEncodingException{
        JWTVerifier verifier =  this.getVerifier();
        return verifier.verify(token);
    }
    public boolean isTokenValid(String token){
        try{

            DecodedJWT jwt = this.getClaims(token);
            LocalDateTime dataExpiracao = jwt.getExpiresAt()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            return !LocalDateTime.now().isAfter(dataExpiracao);
        }catch (UnsupportedEncodingException e){
            return false;
        }
    }
}

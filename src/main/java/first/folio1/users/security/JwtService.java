package first.folio1.users.security;

import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtService{
    String createToken(String subject,Map<String, Object> claims,long expirationMillis);
    //토큰의 유효성을 검사하는 메서드입니다. 토큰이 유효하면 true를 반환하고, 그렇지 않으면 false를 반환합니다.


    //예외 처리의 2가지 방법.
    Claims parseToken(String token);
    Claims getClaimsFromToken(String token);

}
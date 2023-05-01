package first.folio1.policy;

import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtService{
    //토큰의 유효성을 검사하는 메서드입니다. 토큰이 유효하면 true를 반환하고, 그렇지 않으면 false를 반환합니다.


    String createToken(String subject,Map<String, Object> claims,long expirationMillis);
    //토큰 정보 추출
    Claims parseToken(String token);
    //토큰 클레임 정보 추출
    Claims getClaimsFromToken(String token);

}
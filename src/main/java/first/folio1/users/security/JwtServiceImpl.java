package first.folio1.users.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
@Service
public class JwtServiceImpl implements JwtService{
    private final SecretKey secretKey;
    private final long expirationMillis;

    public JwtServiceImpl(@Value("${jwt.secret}") String secret,
                          @Value("${jwt.expirationMillis}") long expirationMillis) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMillis = expirationMillis;
    }

    @Override
    public String createToken(String subject, Map<String, Object> claims, long expirationMillis) {
        Instant now = Instant.now();
        Date issuedAt = Date.from(now);
        Date expiration = Date.from(now.plusMillis(expirationMillis));
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .addClaims(claims)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Claims parseToken(String token)  throws JwtException{
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch(JwtException e){
            // 토큰 유효성 검사에 실패하면 메시지와 함께 예외 던짐
            throw new JwtException("Failed to parse JWT token: " + e.getMessage(), e);
        }
    }
    @Override
    public Claims getClaimsFromToken(String token)  throws JwtException{
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            // 토큰 유효성 검사에 실패하면 메시지와 함께 예외 던짐
                   throw new JwtException("Failed to get claims from token.", e);

        }
    }

}

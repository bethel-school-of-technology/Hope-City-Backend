package com.codebrew.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static com.codebrew.auth.AuthConstants.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.codebrew.models.Users;

//  individually set JWT methods, rather than relying on preset jwt methods by spring, I build them individually based on and example I found, so that I could adjust them individually, specifically the create token and generate token methods in order to take in the proper object, rather than the preset userdetails. 
@Service
public class JwtUtil {

// pulls email of user from token.
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }
// extract Expiration from token, claims include expiration time from token.
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
// extracting claims, resolving claims, applying claims. 
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
// extracting claims from token with parser, setting signing key. 
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

// checking expiration time on token. 
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
// generating token with Users info/ taking in String, and user new claims, into hashmap, returning created token. 
    public String generateToken(Users user) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user.getEmail());
    }

    // creating token setting claims, subject(Users), and issued time, expiration time at 1 hr., signs with algorithm and key. 
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
                
    }
// taking in token and UserDetails, returning wether token is valid.
    public Boolean validateToken(String token, UserDetails user) {
        final String email = extractEmail(token);
        return (email.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
package com.example.StremingApp.security;

import com.example.StremingApp.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final String SECRET_KEY = "your-very-secure-and-long-secret-key";
    private final long EXPIRATION_TIME = 86400000; // 24 hours

    // Méthode recommandée : génère un token à partir de CustomUserDetails
    public String generateToken(UserDetails userDetails) {
        if (!(userDetails instanceof CustomUserDetails)) {
            throw new IllegalArgumentException("Expected CustomUserDetails");
        }

        User user = ((CustomUserDetails) userDetails).getUser();

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("email", user.getEmail())
                .claim("role", user.getRole()) // utile pour frontend
                .claim("authorities", userDetails.getAuthorities().stream()
                        .map(Object::toString)
                        .collect(Collectors.toList())) // injecter ROLE_ADMIN
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    // Ancienne méthode (si tu l’utilises encore dans d'autres endroits)
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public String extractUsername(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username != null &&
                username.equals(userDetails.getUsername()) &&
                !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}
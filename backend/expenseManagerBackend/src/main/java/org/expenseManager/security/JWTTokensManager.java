package org.expenseManager.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.expenseManager.dto.AuthenticatedUserDto;
import org.expenseManager.models.Users;
import org.expenseManager.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTTokensManager {

    final UsersRepository usersRepository;

    public JWTTokensManager(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String generateToken(AuthenticatedUserDto authenticatedUserDto){
        final String email = authenticatedUserDto.getEmail();
        final String firstName = authenticatedUserDto.getFirstName();
        final String lastName = authenticatedUserDto.getLastName();
        final Long id = authenticatedUserDto.getId();

        final Claims claims = Jwts.claims().setSubject(email);
        claims.put("id", id);
        claims.put("firstName", firstName);
        claims.put("lastName", lastName);

        final long currentTimeMills = System.currentTimeMillis();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("ExpenseManager")
                .setIssuedAt(new Date(currentTimeMills))
                .setExpiration(new Date(currentTimeMills + (24 * 60 * 60 * 1000)))
                .signWith(SignatureAlgorithm.HS256, "secretKey@1111")
                .compact();
    }
    public boolean validateToken(String token) {

        final boolean tokenExpired = isTokenExpired(token);
        final Long userId = getUserIdToken(token);
        Users users = usersRepository.findUsersById(userId);
        return users.getFirstName().equals(getAllClaimsFromToken(token).get("firstName")) && users.getLastName().equals(getAllClaimsFromToken(token).get("lastName")) && !tokenExpired;
    }
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey("secretKey@1111").parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {

        final Date expirationDateFromToken = getExpirationDateFromToken(token);
        return expirationDateFromToken.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {

        final Claims claims = getAllClaimsFromToken(token);
        return claims.getExpiration();
    }

    public Long getUserIdToken(String token) {

        final Claims claims = getAllClaimsFromToken(token);
        return Long.parseLong(String.valueOf(claims.get("id")));
    }
}

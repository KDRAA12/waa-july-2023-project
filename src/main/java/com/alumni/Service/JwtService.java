package com.alumni.Service;

import com.alumni.entity.BaseUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    String extractUserName(String token);

    String generateToken(BaseUser baseUser);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isTokenExpired(String token);
}

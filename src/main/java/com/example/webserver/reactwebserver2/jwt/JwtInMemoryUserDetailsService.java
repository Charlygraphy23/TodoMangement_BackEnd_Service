package com.example.webserver.reactwebserver2.jwt;


import com.example.webserver.reactwebserver2.jwt.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

//                {
//                        "token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaXAiLCJleHAiOjE1OTI5ODU0OTYsImlhdCI6MTU5MjM4MDY5Nn0.tH-s5s1JPnE7ufsnQPRiJDZ2N-_A5hroHW9dWscga-d6rU9sQK09xeqBkzlmOOQ_W5_zBKCkJT95XxpoHM6yUQ"
//                        }


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "dip",
                "$2y$12$UlnP7rZCdSRrVBRpPWeAMOqtTl4vJVWtrQYnjYnkHoKemJiGcuMwe", "ROLE_USER_2"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}



package com.app.employee.auth;

import com.app.employee.config.JwtService;
import com.app.employee.user.ROLE;
import com.app.employee.user.User;
import com.app.employee.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRegister authRegister) {
        var user = User.builder()
                .email(authRegister.getEmail())
                .role(ROLE.ROLE_USER)
                .firstName(authRegister.getFirstName())
                .lastName(authRegister.getLastName())
                .password(passwordEncoder.encode(authRegister.getPassword()))
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwt).user(user).build();
    }

    public AuthResponse login(AuthLogin authLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        authLogin.getEmail(),
                        authLogin.getPassword()
                )
        );
        var user = userRepository.findByEmail(authLogin.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwt).user(user).build();
    }


}

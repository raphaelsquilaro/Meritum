package sp.senai.org.meritum.Core.Auth.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sp.senai.org.meritum.Core.Auth.Dto.Request.LoginRequest;
import sp.senai.org.meritum.Core.Auth.Dto.Response.LoginResponse;
import sp.senai.org.meritum.Core.Auth.Exception.InvalidCredentialsException;
import sp.senai.org.meritum.Core.Auth.Security.JwtProvider;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmailValue(request.email())
                .orElseThrow(
                        InvalidCredentialsException::new
                );

        if (!user.getActive()) {
            throw new InvalidCredentialsException();
        }

        if (!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )) {
            throw new InvalidCredentialsException();
        }

        String token = jwtProvider.generateToken(user);

        return new LoginResponse(token);
    }
}
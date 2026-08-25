package sp.senai.org.meritum.Core.Auth.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public JwtFilter(
            JwtProvider jwtProvider,
            UserRepository userRepository
    ) {
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authorization =
                request.getHeader("Authorization");

        if (
                authorization == null ||
                        !authorization.startsWith("Bearer ")
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(7);

        if (!jwtProvider.isValid(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String userId = jwtProvider.getSubject(token);

        User user = userRepository
                .findById(Long.valueOf(userId))
                .orElse(null);

        if (user == null || !user.getActive()) {
            filterChain.doFilter(request, response);
            return;
        }

        String role = user.getRole()
                .getName()
                .name();

        var authority = new SimpleGrantedAuthority(
                "ROLE_" + role
        );

        var authentication =
                new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        List.of(authority)
                );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
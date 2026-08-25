package sp.senai.org.meritum.Core.Auth.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sp.senai.org.meritum.Core.Auth.Dto.Request.LoginRequest;
import sp.senai.org.meritum.Core.Auth.Dto.Response.LoginResponse;
import sp.senai.org.meritum.Core.Auth.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
            ) {
        return ResponseEntity.ok(
                service.login(request)
        );
    }
}

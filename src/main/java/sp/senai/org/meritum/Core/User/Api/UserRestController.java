package sp.senai.org.meritum.Core.User.Api;

import org.springframework.web.bind.annotation.*;
import sp.senai.org.meritum.Core.User.Dto.Request.UserRequest;
import sp.senai.org.meritum.Core.User.Dto.Response.UserResponse;
import sp.senai.org.meritum.Core.User.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {this.service = service;}

    @GetMapping
    public List<UserResponse> findAll() {return  service.findAll();}

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    public UserResponse create(
            @RequestBody UserRequest request
            ) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.delete(id);}
}

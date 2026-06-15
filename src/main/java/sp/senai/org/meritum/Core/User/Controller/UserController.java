package sp.senai.org.meritum.Core.User.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp.senai.org.meritum.Core.User.Dto.UserRequestDTO;
import sp.senai.org.meritum.Core.User.Dto.UserResponseDTO;
import sp.senai.org.meritum.Core.User.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<
            UserResponseDTO
            > create(

            @RequestBody
            UserRequestDTO dto
    ){

        return ResponseEntity.ok(
                service.create(dto)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<
            UserResponseDTO
            > findById(

            @PathVariable
            Long id
    ){

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<
            List<UserResponseDTO>
            > findAll(){

        return ResponseEntity.ok(
                service.findAll()
        );
    }
}
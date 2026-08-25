package sp.senai.org.meritum.Core.User.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sp.senai.org.meritum.Core.Role.Domain.Entity.Role;
import sp.senai.org.meritum.Core.Role.Repository.RoleRepository;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Dto.Request.UserRequest;
import sp.senai.org.meritum.Core.User.Dto.Response.UserResponse;
import sp.senai.org.meritum.Core.User.Exception.EmailAlreadyExistsException;
import sp.senai.org.meritum.Core.User.Exception.UserNotFoundException;
import sp.senai.org.meritum.Core.User.Mapper.UserMapper;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    public UserService(
            UserRepository repository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            UserMapper mapper
    ) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponse findById(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return mapper.toResponse(user);
    }

    public UserResponse create(UserRequest request) {

        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() ->
                        new RoleNotFoundException(request.roleId())
                );

        User user = mapper.toEntity(request);

        user.setPassword(
                passwordEncoder.encode(request.password())
        );

        if (repository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException(
                    request.email().toString()
            );
        }

        user.setActive(true);
        user.setRole(role);

        User savedUser = repository.save(user);

        return mapper.toResponse(savedUser);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        repository.deleteById(id);
    }
}
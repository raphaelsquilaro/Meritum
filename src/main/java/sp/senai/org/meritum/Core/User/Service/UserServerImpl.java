package sp.senai.org.meritum.Core.User.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sp.senai.org.meritum.Core.Role.Domain.Entity.Role;
import sp.senai.org.meritum.Core.Role.Domain.Enuns.RoleName;
import sp.senai.org.meritum.Core.Role.Repository.RoleRepository;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Domain.Enums.UserStatus;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.CPF;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;
import sp.senai.org.meritum.Core.User.Dto.UserRequestDTO;
import sp.senai.org.meritum.Core.User.Dto.UserResponseDTO;
import sp.senai.org.meritum.Core.User.Exception.UserAlreadyExistsException;
import sp.senai.org.meritum.Core.User.Exception.UserNotFoundException;
import sp.senai.org.meritum.Core.User.Mapper.UserMapper;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    @Override    public UserResponseDTO create(
            UserRequestDTO dto
    ) {

        Email email = new Email(dto.email());
        CPF cpf = new CPF(dto.cpf());

        if(repository.existsByEmail(email)){

            throw new UserAlreadyExistsException(
                    "Email already registered"
            );
        }

        if(repository.existsByCpfValue(dto.cpf())){

            throw new UserAlreadyExistsException(
                    "CPF already registered"
            );
        }

        Role role =
                roleRepository
                        .findByName(
                                RoleName.valueOf(
                                        dto.role()
                                )
                        )
                        .orElseThrow();

        User user =
                User.builder()

                        .fullName(
                                dto.fullName()
                        )

                        .email(email)

                        .cpf(cpf)

                        .password(
                                encoder.encode(
                                        dto.password()
                                )
                        )

                        .active(true)

                        .status(
                                UserStatus.ACTIVE
                        )

                        .role(role)

                        .build();

        repository.save(user);

        return mapper
                .toResponse(user);
    }

    @Override
    public UserResponseDTO findById(Long id) {

        User user =
                repository.findById(id)

                        .orElseThrow(() ->
                                new UserNotFoundException(
                                        id
                                )
                        );

        return mapper
                .toResponse(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {

        return repository.findAll()

                .stream()

                .map(mapper::toResponse)

                .toList();
    }
}
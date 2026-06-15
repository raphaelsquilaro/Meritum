package sp.senai.org.meritum.Core.User.Service;

import sp.senai.org.meritum.Core.User.Dto.*;

import java.util.List;

public interface UserService {

    UserResponseDTO create(
            UserRequestDTO dto
    );

    UserResponseDTO findById(
            Long id
    );

    List<UserResponseDTO>
    findAll();
}

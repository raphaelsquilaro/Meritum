package sp.senai.org.meritum.Core.User.Mapper;

import org.springframework.stereotype.Component;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Dto.UserResponseDTO;

@Component
public class UserMapper {

    public UserResponseDTO
    toResponse(User user) {

        return new UserResponseDTO(

                user.getId(),
                user.getEmail(),
                user.getEmail(),
                user.getRole().getName().name(),
                user.getStatus().name()
        );
    }
}

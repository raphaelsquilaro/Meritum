package sp.senai.org.meritum.Core.User.Mapper;

import org.springframework.stereotype.Component;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Dto.Request.UserRequest;
import sp.senai.org.meritum.Core.User.Dto.Response.UserResponse;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCpf(),
                user.getGender(),
                user.getStatus(),
                user.getActive(),
                user.getRole().getId(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }

    public User toEntity(UserRequest request) {

        User user = new User();

        user.setFullName(request.fullName());
        user.setEmail(request.email());
        user.setCpf(request.cpf());
        user.setGender(request.gender());
        user.setStatus(request.status());

        return user;
    }
}

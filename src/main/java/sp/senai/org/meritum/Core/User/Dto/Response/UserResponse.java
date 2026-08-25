package sp.senai.org.meritum.Core.User.Dto.Response;

import sp.senai.org.meritum.Core.User.Domain.Enums.Gender;
import sp.senai.org.meritum.Core.User.Domain.Enums.UserStatus;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.CPF;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;

import java.time.LocalDateTime;

public record UserResponse(

        Long id,

        String fullName,

        Email email,

        CPF cpf,

        Gender gender,

        UserStatus status,

        Boolean active,

        Long roleId,

        LocalDateTime createAt,

        LocalDateTime updateAt
) {
}
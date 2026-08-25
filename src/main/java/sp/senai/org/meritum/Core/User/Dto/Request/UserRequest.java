package sp.senai.org.meritum.Core.User.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sp.senai.org.meritum.Core.User.Domain.Enums.Gender;
import sp.senai.org.meritum.Core.User.Domain.Enums.UserStatus;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.CPF;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;

public record UserRequest(

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 150, message = "Nome deve ter no máximo 150 caracteres")
        String fullName,

        @NotNull(message = "Email é obrigatório")
        Email email,

        @NotNull(message = "CPF é obrigatório")
        CPF cpf,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, message = "Senha deve ter pelo menos 8 caracteres")
        String password,

        Gender gender,

        @NotNull(message = "Status é obrigatório")
        UserStatus status,

        @NotNull(message = "Role é obrigatória")
        Long roleId

) {
}
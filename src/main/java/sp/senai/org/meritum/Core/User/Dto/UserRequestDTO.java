package sp.senai.org.meritum.Core.User.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank(
                message = "Full name is required"
        )
        @Size(
                min = 3,
                max = 150,
                message = "Name must contain between 3 and 150 characters"
        )
        String fullName,

        @NotBlank(
                message = "Email is required"
        )
        @Email(
                message = "Invalid email"
        )
        String email,

        @NotBlank(
                message = "CPF is required"
        )
        @Pattern(
                regexp = "\\d{11}",
                message = "CPF must contain 11 digits"
        )
        String cpf,

        @NotBlank(
                message = "Password is required"
        )
        @Size(
                min = 8,
                message = "Password must contain at least 8 characters"
        )
        String password,

        @NotBlank(
                message = "Role is required"
        )
        String role,

        String gender
) {}
package sp.senai.org.meritum.Core.User.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponseDTO(

        Long id,

        String fullName,

        String email,

        String cpf,

        String role,

        String gender,

        String status,

        String active,

        LocalDateTime createdAt
) {}

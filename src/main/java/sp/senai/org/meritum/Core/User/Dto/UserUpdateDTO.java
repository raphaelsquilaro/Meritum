package sp.senai.org.meritum.Core.User.Dto;

import jakarta.validation.constraints.Size;

public record UserUpdateDTO(

        @Size(
                min = 3,
                max = 150
        )
        String fullName,

        String gender
) {}

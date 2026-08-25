package sp.senai.org.meritum.Core.User.Dto.Update;

import jakarta.validation.constraints.Size;

public record UserUpdate(

        @Size(
                min = 3,
                max = 150
        )
        String fullName,

        String gender
) {}

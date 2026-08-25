package sp.senai.org.meritum.Core.Role.Dto.response;

import sp.senai.org.meritum.Core.Role.Domain.Enuns.RoleName;

public record RoleResponse(
        Long id,
        RoleName name
) {
}

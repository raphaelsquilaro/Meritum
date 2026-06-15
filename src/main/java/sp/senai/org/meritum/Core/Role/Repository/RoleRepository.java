package sp.senai.org.meritum.Core.Role.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.org.meritum.Core.Role.Domain.Entity.Role;
import sp.senai.org.meritum.Core.Role.Domain.Enuns.RoleName;

import java.util.Optional;

public interface RoleRepository
        extends JpaRepository<Role, Long> {

    Optional<Role> findByName(
            RoleName name
    );
}



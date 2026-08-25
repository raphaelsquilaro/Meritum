package sp.senai.org.meritum.Core.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Domain.Enums.UserStatus;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(
            Email email
    );

    boolean existsByEmail(
            Email email
    );

    boolean existsByCpfValue(
            String cpf
    );

    List<User> findByStatus(
            UserStatus status
    );

    List<User> findByActiveTrue();

    Optional<User> findByIdAndActiveTrue(
            Long id
    );

    Optional<User> findByEmailValue(String value);
}

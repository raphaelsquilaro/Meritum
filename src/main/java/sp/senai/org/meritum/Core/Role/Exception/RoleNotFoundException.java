package sp.senai.org.meritum.Core.Role.Exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Long id) {
        super("Role não encontrada com o ID: " + id);
    }
}

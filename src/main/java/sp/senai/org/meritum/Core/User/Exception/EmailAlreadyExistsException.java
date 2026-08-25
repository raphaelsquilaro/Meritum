package sp.senai.org.meritum.Core.User.Exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("Email já cadastrado: " + email);
    }
}

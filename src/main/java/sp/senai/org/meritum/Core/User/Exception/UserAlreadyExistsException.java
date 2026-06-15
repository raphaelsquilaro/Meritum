package sp.senai.org.meritum.Core.User.Exception;

public class UserAlreadyExistsException
        extends RuntimeException {

    public UserAlreadyExistsException(
            String email
    ) {
        super(
                "User already exists: "
                + email
        );
    }
}

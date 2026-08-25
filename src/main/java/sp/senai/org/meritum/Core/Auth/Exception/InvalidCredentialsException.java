package sp.senai.org.meritum.Core.Auth.Exception;

public class InvalidCredentialsException
        extends RuntimeException {

    public InvalidCredentialsException() {
        super("Email ou senha inválidos");
    }

}

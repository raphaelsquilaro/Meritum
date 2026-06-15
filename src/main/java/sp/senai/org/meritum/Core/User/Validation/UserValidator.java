package sp.senai.org.meritum.Core.User.Validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.CPF;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;
import sp.senai.org.meritum.Core.User.Exception.UserAlreadyExistsException;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository repository;

    public void validateCreation(
            Email email,
            CPF cpf
    ) {

        validateEmailUniqueness(email);
        validateCpfUniqueness(cpf);
    }

    public void validateEmailUniqueness(
            Email email
    ) {

        if (repository.existsByEmail(email)) {

            throw new UserAlreadyExistsException(
                    "Email already registered"
            );
        }
    }

    public void validateCpfUniqueness(
            CPF cpf
    ) {

        if (repository.existsByCpfValue(cpf.getValue())) {

            throw new UserAlreadyExistsException(
                    "CPF already registered"
            );
        }
    }

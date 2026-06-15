package sp.senai.org.meritum.Core.User.Domain.ValueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class Email {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final Pattern PATTERN =
            Pattern.compile(EMAIL_REGEX);

    @Column(
            name = "email",
            nullable = false,
            unique = true,
            length = 150
    )
    private String value;

    protected Email() {
        // Required by JPA
    }

    public Email(String value) {

        validate(value);

        this.value =
                value.trim()
                        .toLowerCase();
    }

    private void validate(String email) {

        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be empty"
            );
        }

        if(!PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException(
                    "Invalid email"
            );
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o) return true;

        if(o == null ||
                getClass() != o.getClass())
            return false;

        Email email = (Email) o;

        return Objects.equals(
                value,
                email.value
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

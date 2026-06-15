package sp.senai.org.meritum.Core.User.Domain.ValueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class CPF {

    @Column(
            name = "cpf",
            nullable = false,
            unique = true,
            length = 11
    )
    private String value;

    protected CPF() {
        //
    }

    public CPF(String value) {
        String normalizedCpf =
                normalize(value);

        validate(normalizedCpf);

        this.value = normalizedCpf;
    }

    private String normalize(String cpf) {

        if (cpf == null) {
            throw new IllegalArgumentException(
                    "CPF cannot be null"
            );
        }

        return cpf.replaceAll(
                "[^0-9]",
                ""
        );
    }

    private void validate(String cpf) {

        if (cpf.length() != 11) {
            throw new IllegalArgumentException(
                    "CPF must contain 11 digits"
            );
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            throw new IllegalArgumentException(
                    "Invalid CPF"
            );
        }

        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException(
                    "invalid CPF"
            );
        }
    }

    private boolean isValidCPF(String cpf) {

        int sum = 0;

        for(int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0')
                    * (10 - i);
        }

        int firstDigit =
                11 - (sum % 11);

        if(firstDigit >= 10) {
            firstDigit = 0;
        }

        if(firstDigit !=
                (cpf.charAt(9) - '0')) {
            return false;
        }

        sum = 0;

        for(int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0')
                    * (11 - i);
        }

        int secondDigit =
                11 - (sum % 11);

        if(secondDigit >= 10) {
            secondDigit = 0;
        }

        return secondDigit ==
                (cpf.charAt(10) - '0');
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

        CPF cpf = (CPF) o;

        return Objects.equals(
                value,
                cpf.value
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

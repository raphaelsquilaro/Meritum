package sp.senai.org.meritum.Core.User.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import sp.senai.org.meritum.Core.Role.Domain.Entity.Role;
import sp.senai.org.meritum.Core.User.Domain.Enums.Gender;
import sp.senai.org.meritum.Core.User.Domain.Enums.UserStatus;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.CPF;
import sp.senai.org.meritum.Core.User.Domain.ValueObject.Email;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_user_email",
                columnNames = "email"
        )
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "full_name",
            nullable = false,
            length = 150
    )
    private String fullName;

    @Column(
            nullable = false,
            unique = true,
            length = 150
    )
    @Embedded
    private Email email;

    @Column(
            nullable = false
    )
    @Embedded
    private CPF cpf;

    @Column(
            nullable = false,
            length = 255
    )
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            length = 30
    )
    private UserStatus status;

    @Column(
            nullable = false
    )
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "role_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_user_role"
            )
    )
    private Role role;

    @CreationTimestamp
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at"
    )
    private LocalDateTime updateAt;
}

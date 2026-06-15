package sp.senai.org.meritum.Core.Role.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;
import sp.senai.org.meritum.Core.Role.Domain.Enuns.RoleName;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_role_name",
                        columnNames = "name"
                )
        }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            unique = true,
            length = 50
    )
    private RoleName name;
}

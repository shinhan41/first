package first.folio1.dtoAndEntity.role;

import first.folio1.Enum.AuthRole;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // 역할 이름 (예: ROLE_USER, ROLE_ADMIN)

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles = new ArrayList<>();
}

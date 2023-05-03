package first.folio1.dtoAndEntity.role;

import first.folio1.dtoAndEntity.UserEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole{
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}

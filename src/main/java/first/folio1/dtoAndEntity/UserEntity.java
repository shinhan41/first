package first.folio1.dtoAndEntity;

import first.folio1.Enum.Gender;
import first.folio1.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email; // 아이디

    private String password; // 비밀번호
    private String username; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private LocalDate birthday; // 생년월일 (선택)
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender; // 성별 (선택)

    @Enumerated(EnumType.STRING)
    @Column(name="user_role")
    private UserRole role; // 로그인 토큰(유저,어드민)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public boolean matchPassword(String password){
        return false;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        UserEntity that=(UserEntity)o;
        return getId()!=null&&Objects.equals(getId(),that.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}

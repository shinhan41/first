package first.folio1.dtoAndEntity;
// 회원 정보를 담는 클래스
import first.folio1.Enum.Gender;
import first.folio1.Enum.AuthRole;
import first.folio1.dtoAndEntity.role.DtoRole;
import first.folio1.dtoAndEntity.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity{


    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new ArrayList<>();
    public boolean matchPassword(String password){
        return false;
    }





















    @Id
    @GeneratedValue
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
    private AuthRole role; // 로그인 토큰(유저,어드민)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        UserEntity that=(UserEntity)o;
        return getId()!=null&&Objects.equals(getId(),that.getId());
    }
}

// User 클래스들는 사용자가 입력한 이메일과 비밀번호를 저장하고,
// UserRepository는 이를 조회할 수 있는 기능을 제공합니다.
// Authentication 클래스는 사용자가 인증된 상태인지를 나타내는 정보를 담습니다.
// LoginService는 사용자가 입력한 정보와 MemberRepository에서 조회한 정보를 비교하여 인증을 처리하고,
// 인증 성공 시 Authentication 객체를 생성합니다.
// LogoutService는 Authentication 객체를 삭제하여 로그아웃을 처리합니다.

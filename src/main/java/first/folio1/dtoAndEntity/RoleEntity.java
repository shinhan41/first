package first.folio1.dtoAndEntity;

import first.folio1.Enum.Gender;
import first.folio1.Enum.UserRole;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id", nullable=false)
    private Long id;


    private String email; // 아이디
    private String password; // 비밀번호
    private String username; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private LocalDate birthday; // 생년월일 (선택)
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender; // 성별 (선택)
    private LocalDateTime createdAt; //Create 시점
    private LocalDateTime updatedAt; //update 시점
    private UserRole role; // 로그인 토큰(유저,어드민)
    public boolean matchPassword(String password){
        return false;
    }
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<UserEntity> users = new ArrayList<>();

    private String name;
    public String getName() {
        return this.name;
    }
    public Long getId() {
        return id;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        RoleEntity that=(RoleEntity)o;
        return getId()!=null&&Objects.equals(getId(),that.getId());
    }


}

package first.folio1.dtoAndEntity;

import first.folio1.Enum.Gender;
import first.folio1.dtoAndEntity.role.DtoRole;
import first.folio1.dtoAndEntity.role.RoleEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto{
    private List<? extends GrantedAuthority> authorities;


    private List<DtoRole> roles;

    public boolean matchPassword(String password){
        return this.password.equals(password);

    }
    public static UserDto fromEntity(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setEmail(userEntity.getEmail());

        List<DtoRole> roleDtos = userEntity.getUserRoles().stream()
                .map(userRole -> {
                    RoleEntity role = userRole.getRole();
                    return new DtoRole(role.getId(), role.getName());
                }).collect(Collectors.toList());

        userDto.setRoles(roleDtos);
        return userDto;
    }












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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
}
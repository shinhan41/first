package first.folio1.dtoAndEntity;
import first.folio1.Enum.Gender;
import first.folio1.Enum.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto2{

    private Long id;
    private String email; // 아이디
    private String password; // 비밀번호
    private String username; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private LocalDate birthday; // 생년월일 (선택)
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender; // 성별 (선택)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserRole role; // 로그인 토큰(유저,어드민)


    public boolean matchPassword(String password){
        return false;
    }

    private List<? extends GrantedAuthority> authorities; // 어드민 권한 부여 받은 객체들 리스트


    public static UserDto2 fromEntity(UserEntity userEntity) {
        UserDto2 userDto2= new UserDto2();

        userDto2.setEmail(userEntity.getEmail());
        userDto2.setPassword(userEntity.getPassword());
        // 추가적으로 필요한 필드들가 있을까

        UserDetails userDetails = userEntity.toUserDetails();
        userDto2.setAuthorities((List<? extends GrantedAuthority>)userDetails.getAuthorities());
        userDto2.setUsername(userDetails.getUsername());

        return userDto2;
    }





}
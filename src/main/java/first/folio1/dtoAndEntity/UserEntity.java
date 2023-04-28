package first.folio1.dtoAndEntity;
// 회원 정보를 담는 클래스
import first.folio1.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity{
    @Id @GeneratedValue
    private Long id;

    private String email; // 아이디
    private String password; // 비밀번호
    private String username; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private LocalDate birthday; // 생년월일 (선택)

    private LocalDateTime createdAt; //Create 시점
    private LocalDateTime updatedAt; //update 시점

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender; // 성별 (선택)

    @Builder
    public UserEntity(String username,String password,String email,String name,
                      LocalDate birthday,Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.username = name;
        this.birthday = birthday;
        this.gender = gender;
    }

// User 클래스들는 사용자가 입력한 이메일과 비밀번호를 저장하고,
// UserRepository는 이를 조회할 수 있는 기능을 제공합니다.
// Authentication 클래스는 사용자가 인증된 상태인지를 나타내는 정보를 담습니다.
// LoginService는 사용자가 입력한 정보와 MemberRepository에서 조회한 정보를 비교하여 인증을 처리하고,
// 인증 성공 시 Authentication 객체를 생성합니다.
// LogoutService는 Authentication 객체를 삭제하여 로그아웃을 처리합니다.
}

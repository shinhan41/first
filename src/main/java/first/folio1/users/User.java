package first.folio1.users;
// 회원 정보를 담는 클래스
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id @GeneratedValue
    private Long id;

    private String email; // 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private String birthday; // 생년월일 (선택)
    private String gender; // 성별 (선택)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




//Member 클래스는 사용자가 입력한 이메일과 비밀번호를 저장하고,
// MemberRepository는 이를 조회할 수 있는 기능을 제공합니다.
// Authentication 클래스는 사용자가 인증된 상태인지를 나타내는 정보를 담습니다.
// LoginService는 사용자가 입력한 정보와 MemberRepository에서 조회한 정보를 비교하여 인증을 처리하고,
// 인증 성공 시 Authentication 객체를 생성합니다.
// LogoutService는 Authentication 객체를 삭제하여 로그아웃을 처리합니다.
}

//package first.folio1.dtoAndEntity;
//// 회원 정보를 담는 클래스
//import first.folio1.Enum.Gender;
//
//import first.folio1.Enum.UserRole;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserEntitys{
//    @Id @GeneratedValue
//    private Long id;
//
//    private String email; // 아이디
//    private String password; // 비밀번호
//    private String username; // 이름
//    private String phone; // 연락처 (선택)
//    private String address; // 주소 (선택)
//    private LocalDate birthday; // 생년월일 (선택)
//    @Enumerated(EnumType.STRING)
//    @Column(name = "gender")
//    private Gender gender; // 성별 (선택)
//    private LocalDateTime createdAt; //Create 시점
//    private LocalDateTime updatedAt; //update 시점
//    private UserRole role; // 로그인 토큰(유저,어드민)
//    public boolean matchPassword(String password){
//        return false;
//    }
//
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<RoleEntity> roles = new ArrayList<>();
//    public UserDetails toUserDetails() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (RoleEntity role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getUsername()));
//        }
//        return new User(username, password, authorities);
//    }
//
//    public boolean isEnabled(){
//        //// 사용자 계정이 사용 가능한 상태인지 여부를 반환합니다. -이 기능 안쓸듯.
//        return true;
//    }
//}
//
//
//
//
//// User 클래스들는 사용자가 입력한 이메일과 비밀번호를 저장하고,
//// UserRepository는 이를 조회할 수 있는 기능을 제공합니다.
//// Authentication 클래스는 사용자가 인증된 상태인지를 나타내는 정보를 담습니다.
//// LoginService는 사용자가 입력한 정보와 MemberRepository에서 조회한 정보를 비교하여 인증을 처리하고,
//// 인증 성공 시 Authentication 객체를 생성합니다.
//// LogoutService는 Authentication 객체를 삭제하여 로그아웃을 처리합니다.

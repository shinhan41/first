package first.folio1.Controller;

import first.folio1.dtoAndEntity.LoginResponseDTO;
import first.folio1.dtoAndEntity.UserDto;
import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserRepository;
import first.folio1.policy.JwtService;
import first.folio1.users.security.JwtServiceImpl;
import first.folio1.dtoAndEntity.LoginRequest;
import first.folio1.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
//@SessionAttributes("loginUser")
@RequestMapping("/users")
public class UserController{
    private UserRepository userRepository;

    @GetMapping("/login")// 로그인 페이지 로드
    public String login() {
        return "login";
    }

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    //일반 로그인
    private UserServiceImpl userServiceImpl;

    //로그인 성공시 JWT 토큰 발급.로그인한 사용자 정보 반환용으로 써도됨
    private LoginResponseDTO loginResponseDTO;
    private JwtServiceImpl jwtServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    //일반 로그인처리
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
    try {
        UserEntity userEntity = userServiceImpl.login(request.getUsername(), request.getPassword());
        UserDto userDto = UserDto.fromEntity(userEntity);
        return ResponseEntity.ok(userDto);
    } catch (UserNotFoundException e) {//로그인 성공
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    } catch (IllegalArgumentException e) {//로그인 실패
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}












//    로그아웃 처리 (현재 로그인한 사용자의 세션을 만료시킴)
        @PostMapping("/logout")
        public ResponseEntity<String> logout(HttpSession session) {
            userServiceImpl.logout(session);
//            httpSession.invalidate();
//            return "redirect:/";
            return ResponseEntity.ok("Logout successful.");
        }

    }




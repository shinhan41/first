package first.folio1.Controller;

import first.folio1.dtoAndEntity.LoginResponseDTO;
import first.folio1.dtoAndEntity.UserDto;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserService;
import first.folio1.security.JwtService;
import first.folio1.security.JwtServiceImpl;
import first.folio1.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@SessionAttributes("loginUser")
@RequestMapping("/users")
public class UserController{
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private HttpSession httpSession;

    private LoginResponseDTO loginResponseDTO;
    private JwtServiceImpl jwtServiceImpl;
    private  UserService userService;
    private UserServiceImpl userServiceImpl;



    public UserController(UserService userService) {
        this.userService = userService;


//    HTTP 로그인 처리login(userId, password);
//@PostMapping("/login")
//public ResponseEntity<UserDto> login(@RequestParam String userId, @RequestParam String password) {
//    //로그인 처리 메소드
//    try {
//        UserEntity userEntity = userService.save()
//        return ResponseEntity.ok(userEntity);
//        //로그인 성공
//    } catch (UserNotFoundException e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        //로그인 실패
//    } catch (IllegalArgumentException e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//}
//    userservice 로그인 처리login(userId, password);
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            // 로그인 요청을 처리하는 코드
            // UserServiceImpl의 로그인 기능을 호출하여 결과를 반환
            // 반환된 결과에 따라 적절한 ResponseEntity 반환
            // ...
        }

//    로그아웃 처리
        @PostMapping("")
        public String logout() {
    // 현재 로그인한 사용자의 세션을 만료시킴
         httpSession.invalidate();
          return "redirect:/";
}
//    사용저 정보 조회 처리




}


package first.folio1.Controller;

import first.folio1.exceptions.UserNotFoundException;
import first.folio1.users.Login;
import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.policy.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("loginUser")
public class LoginController {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }


//    로그인 처리
@PostMapping("/login")
public ResponseEntity<UserEntity> login(@RequestParam String username, @RequestParam String password) {
    //로그인 처리 메소드
    try {
        UserEntity userEntity = userService.login(username, password);
        return ResponseEntity.ok(userEntity);
        //로그인 성공
    } catch (UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        //로그인
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
//    로그아웃 처리
@PostMapping("/logout")
public String logout() {
    // 현재 로그인한 사용자의 세션을 만료시킴
    httpSession.invalidate();
    return "redirect:/";
}
//    사용저 정보 조회 처리




}


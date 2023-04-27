package first.folio1.Controller;

import first.folio1.users.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class JoinController{



    @GetMapping("/register")
    public String register() {
        // 회원가입 페이지 로직 처리
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User userRequest) {
        // 회원가입 로직 처리
        User user= user.register(userRequest);
        return "redirect:/login";
    }


}

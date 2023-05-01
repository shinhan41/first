package first.folio1.Controller;

import first.folio1.dtoAndEntity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController{

    @GetMapping("/register")
    public String register() {
        // 회원가입 페이지 로직 처리
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserEntity userEntityRequest) {
        // 회원가입 로직 처리
        UserEntity userEntity= userEntityRequest.register(userEntityRequest);
        return "redirect:/login";
    }


}

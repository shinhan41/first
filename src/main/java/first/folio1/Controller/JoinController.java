package first.folio1.Controller;

import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.DuplicateUsernameException;
import first.folio1.users.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController{

    private UserServiceImpl userServiceImpl;

    //회원가입
    @GetMapping("/join")// 회원가입 페이지 로드
    public String join() {
        return "join";
    }

    @PostMapping("/join")// 회원가입 처리
    public String register(@ModelAttribute UserEntity userEntityRequest){
        try{
            userServiceImpl.Join(userEntityRequest);//회원가입시 엔티티에 등록
            return "redirect:/login";
        }
        catch(DuplicateUsernameException e){ // 중복 예외처리
            return "redirect:/register?error=duplicate";
        }
        catch(Exception e){ // 기타 예외 처리
            return "redirect:/register?error=unknown";
        }
    }
}
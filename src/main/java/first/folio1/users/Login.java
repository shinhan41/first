package first.folio1.users;

import first.folio1.policy.UserRepository;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Login{


    private UserRepository userRepository;

    public Login(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User login(String username,String password){
        User user=userRepository.findByUsername(username)
                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 아이디입니다."));
        if(!password.equals(user.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return user;
    }
}
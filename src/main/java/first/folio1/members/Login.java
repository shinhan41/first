package first.folio1.members;

import first.folio1.members.Member;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Login{


    public boolean login(String email, String password) {
        // 사용자가 입력한 정보가 데이터베이스에 있는 회원 정보와 일치하는지 확인합니다.
        // 만약 일치한다면, 로그인을 허용합니다.

        boolean isValidUser = false;

        // 이 부분은 데이터베이스 연동 등의 처리로 구현해야 합니다.
        Member member = findMemberByEmail(email);

        if (member != null && member.getPassword().equals(password)) {
            isValidUser = true;

            // 로그인 정보를 세션에 저장합니다.
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
        }

        return isValidUser;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Login loginRequest, HttpSession session) {
        // 로그인 로직 처리
        Member loginUser = member.login(loginRequest);
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
            return "redirect:/";
        } else {
            return "login";
        }
    }
    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
    @Builder
    public Member(String email, String password, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

package first.folio1.Controller;

import first.folio1.members.Login;
import first.folio1.members.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
    @Controller
    public class HomeController {
        Login member;

        @GetMapping("/")
        public String home(Model model) {
            // 홈 페이지 로직 처리
            return "index";
        }

        @GetMapping("/login")
        public String login() {
            // 로그인 페이지 로직 처리
            return "login";
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

        @GetMapping("/register")
        public String register() {
            // 회원가입 페이지 로직 처리
            return "register";
        }

        @PostMapping("/register")
        public String register(@ModelAttribute Member memberRequest) {
            // 회원가입 로직 처리
            Member member = member.register(memberRequest);
            return "redirect:/login";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            // 로그아웃 로직 처리
            session.invalidate();
            return "redirect:/";
        }
    }


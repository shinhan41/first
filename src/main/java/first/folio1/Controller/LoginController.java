package first.folio1.Controller;

import org.springframework.stereotype.Controller;

@Controller

//@SessionAttributes("loginUser")
public class LoginController {

//    @Autowired
//    private MemberService memberService;
//
//    @GetMapping("/login")
//    public String loginForm(Model model) {
//        model.addAttribute("loginForm", new LoginForm());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpSession session) {
//        Member loginMember = memberService.login(loginForm.getEmail(), loginForm.getPassword());
//        if (loginMember == null) {
//            // 로그인 실패 처리
//            return "login";
//        } else {
//            // 로그인 성공 처리
//            session.setAttribute("loginUser", loginMember);
//            return "redirect:/";
//        }
//    }
//
//    @GetMapping("/mypage")
//    public String myPage(@ModelAttribute("loginUser") Member loginUser, Model model) {
//        // 로그인한 사용자 정보를 이용한 페이지 구현
//        model.addAttribute("loginUser", loginUser);
//        return "mypage";
//    }
}


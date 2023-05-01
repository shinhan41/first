package first.folio1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
    @Controller
    public class HomeController {

        @GetMapping("/")
        public String home(Model model) {
            // 홈 페이지 로직 처리
            return "index";
        }




//
//        try {
//            Order order = orderService.getOrderById(orderId);
//            // 주문 정보를 가져온 후에 처리할 로직 작성
//        } catch (
//        OrderNotFoundException e) {
//            // 주문 정보가 없는 경우 예외 처리
//            // 사용자에게 적절한 메시지 제공 등의 작업 수행
//        }
    }


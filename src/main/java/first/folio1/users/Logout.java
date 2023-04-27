package first.folio1.users;

import javax.servlet.http.HttpSession;

public class Logout{

    public void logout(HttpSession session) {
        session.removeAttribute("loginUser");
    }

}

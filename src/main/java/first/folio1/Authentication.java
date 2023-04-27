package first.folio1;
//사용자 인증을 위한 클래스


import first.folio1.users.User;
import first.folio1.policy.UserRepository;
import lombok.Data;

@Data
public class Authentication{


    private final UserRepository userRepository;

    public Login(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public Authentication login(String email, String password) {
        User user= userRepository.findByEmail(email);
        if (user== null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (!user.matchPassword(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return new Authentication(user);
    }

}

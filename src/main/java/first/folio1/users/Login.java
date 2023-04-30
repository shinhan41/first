package first.folio1.users;

import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserRepository;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class Login{


    private UserRepository userRepository;

    public Login(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    //로그인  처리 메소드
    public UserEntity login(String username, String password) throws UserNotFoundException {
        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(username);
        if (!userEntityOpt.isPresent()) {
            throw new UserNotFoundException("가입되지 않은 아이디입니다.");
        }
        UserEntity userEntity = userEntityOpt.get();
        if (!password.equals(userEntity.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return userEntity;
    }
}
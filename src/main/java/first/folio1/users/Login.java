package first.folio1.users;

import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.policy.UserRepository;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Login{


    private UserRepository userRepository;

    public Login(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserEntity login(String username,String password){
        UserEntity userEntity=userRepository.findByUsername(username)
                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 아이디입니다."));
        if(!password.equals(userEntity.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return userEntity;
    }
}
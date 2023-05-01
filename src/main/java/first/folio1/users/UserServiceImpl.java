package first.folio1.users;

import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.DuplicateUsernameException;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserServiceImpl<U>{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//   ==================== 회원가입 기능*****
public UserEntity Join(UserEntity user) throws DuplicateUsernameException {
    // 중복된 사용자 이름이 있는지 검사
    if(userRepository.existsByUsername(user.getUsername())){
        throw new DuplicateUsernameException("이미 존재하는 아이디입니다. "+user.getUsername());
    }else{
        // User 엔티티를 저장
        UserEntity savedUser = userRepository.save(user);
    }
    return (UserEntity) userRepository.save();
}

// ===================== 로그인 기능*****
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
    //================================log out
    public void logout(HttpSession session) {
        session.removeAttribute("loginUser");
    }

}





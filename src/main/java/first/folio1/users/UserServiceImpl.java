package first.folio1.users;

import first.folio1.policy.UserRepository;
import first.folio1.policy.UserService;
import org.apache.catalina.User;

public class UserServiceImpl extends UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        // 회원가입 처리 로직 구현
        // ...
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User login(String userId, String password) {
        // 로그인 처리 로직 구현
        // ...
        User user = userRepository.findByUserIdAndPassword(userId, password)
                .orElseThrow(() -> new RuntimeException("로그인 정보가 일치하지 않습니다."));
        return user;
    }

    @Override
    public User getUser(String userId) {
        // 사용자 정보 조회 로직 구현
        // ...
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("해당 사용자 정보가 없습니다."));
        return user;
    }

    @Override
    public User updateUser(User user) {
        // 사용자 정보 수정 로직 구현
        // ...
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(long userId) {
        // 사용자 정보 삭제 로직 구현
        // ...
        userRepository.deleteById(userId);
    }
}


}

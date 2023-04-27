package first.folio1.policy;

import first.folio1.users.Login;
import first.folio1.users.User;
import first.folio1.exceptions.UserAlreadyExistsException;
import first.folio1.exceptions.UserNotFoundException;

import java.util.Optional;
//비즈니스 로직을 처리하는 인터페이스입니다.
// 즉, 사용자가 요청한 작업을 처리하기 위한 비즈니스 로직을 구현합니다.
// 새로운 사용자 생성, 사용자 정보 조회, 사용자 정보 업데이트, 사용자 정보 삭제
public interface UserService {


    // 회원가입 처리 메서드
    // @param user 회원가입 정보를 담고 있는 User 객체
    // @return 회원가입 완료된 User 객체
    void createUser(User user) throws UserAlreadyExistsException;

    // 로그인 처리 메서드
    // @param userId 사용자 ID
    // @param password 사용자 비밀번호
    // @return 로그인 완료된 User 객체
    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
        return user.get();
    }

    // 사용자 정보 조회 메서드
    // @param userId 사용자 ID
    // @return 해당 ID를 가진 사용자의 정보를 담고 있는 User 객체
    //지정된 사용자를 업데이트합니다. 해당 사용자가 존재하지 않는 경우 UserNotFoundException이 발생합니다.


    // 사용자 정보 수정 메서드
    // @param user 수정할 정보를 담고 있는 User 객체
    // @return 수정된 User 객체
    User updateUser(User user) throws UserNotFoundException;;

    // 사용자 삭제 메서드
    // @param userId 삭제할 사용자의 ID
    void deleteUser(String userId);


    org.apache.catalina.User login(String userId,String password);

    void deleteUser(long userId);

    first.folio1.users.User login(Login loginRequest);
}

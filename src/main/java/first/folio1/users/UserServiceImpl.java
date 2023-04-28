package first.folio1.users;

import first.folio1.dtoAndEntity.UserDto;
import first.folio1.exceptions.DuplicateUsernameException;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserRepository;
import first.folio1.policy.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto signUp(UserDto userDto) throws DuplicateUsernameException{
        // 중복된 사용자 이름이 있는지 검사
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new DuplicateUsernameException("Username already exists: " + userDto.getUsername());
        }

        // UserDto를 User 엔티티로 매핑
        User user = User.builder()
                .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .build();

        // User 엔티티를 저장
        User savedUser = userRepository.save(user);

        // 저장된 User 엔티티를 UserDto로 매핑하여 반환
        return UserDto.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .build();
    }

    @Override
    public UserDto getUserById(Long userId) throws UserNotFoundException {
        // 주어진 ID에 해당하는 사용자를 찾음
        Optional<User> optionalUser = userRepository.findById(userId);

        // 사용자가 존재하지 않으면 예외 발생
        User user = optionalUser.orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        // User 엔티티를 UserDto로 매핑하여 반환
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    // 다른 메서드 생략

}
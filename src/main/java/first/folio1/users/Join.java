package first.folio1.users;

import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.policy.UserRepository;


public class Join {
    private UserRepository userRepository;

    public Join(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserEntity user) {
        userRepository.save();
    }

    public void validateDuplicateUser(UserEntity user) throws UserNotFoundException {
        UserEntity existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

}

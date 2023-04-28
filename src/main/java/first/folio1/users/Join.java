//package first.folio1.users;
//
//import first.folio1.policy.UserRepository;
//
//public class Join {
//    private UserRepository userRepository;
//
//    public Join(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void registerUser(User user) {
//        userRepository.save(user);
//    }
//
//    public void validateDuplicateUser(User user) {
//        userRepository.findByUsername(user.getUsername())
//                .ifPresent(u -> {
//                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
//                });
//    }
//
//}

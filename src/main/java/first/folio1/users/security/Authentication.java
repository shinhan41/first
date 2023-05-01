//package first.folio1.users.security;
////사용자 인증을 위한 클래스
//
//
//import first.folio1.exceptions.UserNotFoundException;
//import first.folio1.dtoAndEntity.UserEntity;
//import first.folio1.policy.UserRepository;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Authentication{
//
//
//    private UserRepository userRepository;
//
//    public void Login(UserRepository userRepository) {
//        this.userRepository=userRepository;
//    }
//
//    public Authentication login(String email, String password) {
//        UserEntigetAuthorityty userEntity=null;
//        try{
//            userEntity=userRepository.findByEmail(email);
//        }
//        catch(UserNotFoundException e){
//            throw new RuntimeException(e);
//        }
//        if (userEntity== null) {
//            throw new IllegalArgumentException("Invalid email or password");
//        }
//        if (!userEntity.matchPassword(password)) {
//            throw new IllegalArgumentException("Invalid email or password");
//        }
//        return new Authentication(userEntity);
//    }
//
//}

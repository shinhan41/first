package first.folio1.policy;

import first.folio1.dtoAndEntity.UserDto;
import first.folio1.exceptions.DuplicateUsernameException;
import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.exceptions.UserAlreadyExistsException;
import first.folio1.exceptions.UserNotFoundException;

import java.util.List;

//비즈니스 로직을 처리하는 인터페이스입니다.
// 즉, 사용자가 요청한 작업을 처리하기 위한 비즈니스 로직을 구현합니다.
// 새로운 사용자 생성, 사용자 정보 조회, 사용자 정보 업데이트, 사용자 정보 삭제
public interface UserService{

    //CRUD-Start=========================================

    // C.회원가입 처리 메서드(디비에 바로 담김)
    //새로운 사용자를 생성합니다. 이미 있는id면 익셉션에 던짐
    void createUser(UserEntity userEntity) throws UserAlreadyExistsException;

    // R.로그인 처리 + DTO에서 로그인처리
    //지정된 ID를 가진 사용자를 반환합니다. 없으면 익셉션에 던짐
    UserEntity getUserById(Long userId) throws UserNotFoundException;
    UserDto signUp(UserDto userDto) throws DuplicateUsernameException;

    // U.사용자 정보 수정 메서드. 없으면 익셉션에 던짐
    UserEntity updateUser(UserEntity userEntity) throws UserNotFoundException;

    //U_2.모든 사용자 목록 반환
    List<UserEntity> getAllUsers();

    // D_1.ID로삭제 메서드
    void deleteById(Long userId);
    //D_2.NAME으로 삭제 메서드
    void deleteUser(String userName);

    //CRUD-END=========================================

    void signUp();


    //for Test.회원가입,조회 메서드 (이건 어드민에서 쓰거나 테스트에서 메서드)
    //새로운 사용자를 추가하고, 추가된 사용자를 반환합니다. 이미 동일한 ID를 가진 사용자가 존재하는 경우 UserAlreadyExistsException이 발생합니다.
    UserEntity userJoin(UserEntity userEntity) throws UserAlreadyExistsException;


    //for Test DTO에서.회원가입,조회 메서드 (이건 어드민에서 쓰거나 테스트에서 메서드)
    //새로운 사용자를 추가하고, 추가된 사용자를 반환합니다. 이미 동일한 ID를 가진 사용자가 존재하는 경우 UserExistException이 발생합니다.
//    void userJoin(UserDto userDto) throws UserExistException;
}

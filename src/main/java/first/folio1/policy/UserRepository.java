package first.folio1.policy;
//회원 정보를 저장하고 조회하는 기능을 담당하는 클래스


import first.folio1.exceptions.UserNotFoundException;
import first.folio1.dtoAndEntity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//CRUD (Create, Read, Update, Delete)

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    long count();

    User save();

    //모든 사용자를 반환합니다.
    List<UserEntity> findAll();

    //유저 네임으로 조회
    Optional<UserEntity> findByUsername(String username) throws UserNotFoundException;

    // 사용자 이메일로 멤버 조회
    Optional<UserEntity> findByEmail(String email)throws UserNotFoundException;

    // 사용자 이름이나 이메일로 멤버 조회
    List<UserEntity> findByNameOrEmail(String name,String email)throws UserNotFoundException;

    // 사용자 이름이나 이메일로 멤버 조회 (정렬)
    List<UserEntity> findByNameOrEmailOrderByNameAsc(String name,String email)throws UserNotFoundException;


    // 주어진 ID에 해당하는 사용자가 존재하는지 확인
    boolean existsById(Long userId);
    // 주어진 ID에 해당하는 사용자가 존재하는지 확인
    boolean existsByUsername(String userName);

    //주어진 ID에 해당하는 사용자를 삭제합니다.
    void deleteById(Long userId);
    void deleteByName(String userName);
    //사용자의 총 수를 반환합니다.

}


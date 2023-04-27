package first.folio1.policy;
//회원 정보를 저장하고 조회하는 기능을 담당하는 클래스


import first.folio1.exceptions.ProductNotFoundException;
import first.folio1.exceptions.UserNotFoundException;
import first.folio1.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//CRUD (Create, Read, Update, Delete)

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    //유저 네임으로 조회
    User findByUsername(String username) throws UserNotFoundException;


    // 유저 이메일로 조회
    List<User> findByName(String name)throws UserNotFoundException;

    // 사용자 이메일로 멤버 조회
    Optional<User> findByEmail(String email)throws UserNotFoundException;



    // 사용자 이름이나 이메일로 멤버 조회
    List<User> findByNameOrEmail(String name,String email)throws UserNotFoundException;

    // 사용자 이름이나 이메일로 멤버 조회 (정렬)
    List<User> findByNameOrEmailOrderByNameAsc(String name,String email)throws UserNotFoundException;



}


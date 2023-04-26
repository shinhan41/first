package first.folio1.policy;
//회원 정보를 저장하고 조회하는 기능을 담당하는 클래스


import first.folio1.members.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 리포지토리 메소드 정의

    // 사용자 이름으로 멤버 조회
    List<Member> findByName(String name);

    // 사용자 이메일로 멤버 조회
    Optional<Member> findByEmail(String email);

    // 사용자 이름이나 이메일로 멤버 조회
    List<Member> findByNameOrEmail(String name, String email);

    // 사용자 이름이나 이메일로 멤버 조회 (정렬)
    List<Member> findByNameOrEmailOrderByNameAsc(String name, String email);


}


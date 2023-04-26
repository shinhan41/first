package first.folio1;
//사용자 인증을 위한 클래스


import first.folio1.members.Member;
import first.folio1.policy.MemberRepository;
import lombok.Data;

@Data
public class Authentication{


    private final MemberRepository memberRepository;

    public Login(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Authentication login(String email, String password) {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (!member.matchPassword(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return new Authentication(member);
    }

}

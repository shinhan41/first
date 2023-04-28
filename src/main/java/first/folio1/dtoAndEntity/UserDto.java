package first.folio1.dtoAndEntity;
import first.folio1.Enum.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String email; // 아이디
    private String password; // 비밀번호
    private String username; // 이름
    private String phone; // 연락처 (선택)
    private String address; // 주소 (선택)
    private LocalDate birthday; // 생년월일 (선택)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender; // 성별 (선택)



    @Builder
    public UserDto(String username,String password,String email,String name,
                      LocalDate birthday,Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.username = name;
        this.birthday = birthday;
        this.gender = gender;
    }


}
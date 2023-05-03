package first.folio1.dtoAndEntity.auth;

import first.folio1.dtoAndEntity.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO{

    private String accessToken;
    private UserDto userDto;

//    void getUsername(){
//
//    };
//    void getPassword(){
//
//    };

}

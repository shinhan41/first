package first.folio1.dtoAndEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO{
    private String accessToken;
    private UserDto userDto;
}

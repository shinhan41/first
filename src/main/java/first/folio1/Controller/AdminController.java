package first.folio1.Controller;

import first.folio1.dtoAndEntity.UserDto;
import first.folio1.dtoAndEntity.UserEntity;
import first.folio1.policy.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class AdminController{


    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    UserDto userDto = modelMapper.map(UserEntity.class, UserDto.class);
    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserEntity>> getUsers() {
        // 관리자 권한이 있는 경우에만 조회 가능
        List<UserEntity> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}

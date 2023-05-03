package first.folio1.Controller;

import first.folio1.dtoAndEntity.*;
import first.folio1.dtoAndEntity.auth.LoginRequest;
import first.folio1.dtoAndEntity.auth.LoginResponseDTO;
import first.folio1.dtoAndEntity.UserDto;
import first.folio1.users.security.JwtServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtServiceImpl jwtServiceImpl;
    @Autowired
    private UserDetailsService userDetailsService;
    private  SecretKey secretKey;
    private  long expirationMillis;
    ModelMapper modelMapper = new ModelMapper();

    UserDto userDto = modelMapper.map(UserEntity.class, UserDto.class);


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtServiceImpl.createToken(userDetails.getUsername(), new HashMap<>(), expirationMillis);

        UserDto userDto = new UserDto();
        userDto.setUsername(userDetails.getUsername());

        userDto.setAuthorities((List<? extends GrantedAuthority>)userDetails.getAuthorities());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setUserDto(userDto);
        response.setAccessToken(token);



        return ResponseEntity.ok(response);
    }
}
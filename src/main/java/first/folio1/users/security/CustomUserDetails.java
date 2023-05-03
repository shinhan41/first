package first.folio1.users.security;

import first.folio1.Enum.UserRole;
import first.folio1.dtoAndEntity.RoleEntity;
import first.folio1.dtoAndEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails  {

    private UserEntity userEntity;
    private UserRole role;
    private User user;
    public CustomUserDetails(UserEntity user) {
        this.userEntity = user;
    }
    @Override
    public String getUsername() {
        // 사용자의 아이디를 반환합니다.
        return userEntity.getUsername();
    }


    @Override
    public String getPassword() {
        // 사용자의 비밀번호를 반환합니다.
        return userEntity.getPassword();
    }


    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        // 사용자의 권한 정보를 반환합니다.
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }



    @Override
    public boolean isAccountNonExpired() {
        // 사용자 계정이 만료되었는지 여부를 반환합니다.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 사용자 계정이 잠겨있는지 여부를 반환합니다.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 사용자의 인증 정보가 만료되었는지 여부를 반환합니다.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 사용자 계정이 사용 가능한 상태인지 여부를 반환합니다.
        return user.isEnabled();
    }

}

package first.folio1.users.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    private static final String SECRET = "my-secret";

    private final PasswordEncoder delegate;

    public MyPasswordEncoder() {
        this.delegate = new StandardPasswordEncoder(SECRET);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return delegate.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return delegate.matches(rawPassword, encodedPassword);
    }

}
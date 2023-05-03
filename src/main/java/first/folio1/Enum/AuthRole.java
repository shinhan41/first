package first.folio1.Enum;

public enum AuthRole{
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String authority;

    AuthRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
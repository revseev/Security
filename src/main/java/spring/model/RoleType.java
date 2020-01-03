package spring.model;

public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN");

    public String roleType;

    private RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String asString() {
        return roleType;
    }
}

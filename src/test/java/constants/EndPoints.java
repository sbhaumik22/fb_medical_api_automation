package constants;

public enum EndPoints {
    USER_SIGN_UP("/api/v1/user/auth/sign_up"),
    USER_LOGIN("/api/v1/user/auth/sign_in"),
    USER_DELETE("/api/v1/user/profile"),
    USER_DETAILS("/api/v1/user/profile");


    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

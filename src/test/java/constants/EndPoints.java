package constants;

public enum EndPoints {
    USER_SIGN_UP_PRE_CHECK("/api/v1/user/auth/presign_up"),
    USER_SIGN_UP("/api/v1/user/auth/sign_up"),
    USER_LOGIN("/api/v1/user/auth/sign_in"),
    USER_DELETE("/api/v1/user/profile"),
    USER_DETAILS("/api/v1/user/profile"),
    USER_UPLOAD_MEDIA("/api/v1/media/user/upload"),
    CREATE_PROFILE_VERIFICATION_REQUEST("/api/v1/user/profile/verification");

    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

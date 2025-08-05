package constants;

public enum Environments {
    DEV("https://backend-stage.fvhospital.com"),
    UAT("https://uat.api.fvhospital.com"),
    PROD("https://api.fvhospital.com");

    private final String baseUri;

    Environments(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getBaseUri() {
        return baseUri;
    }
}

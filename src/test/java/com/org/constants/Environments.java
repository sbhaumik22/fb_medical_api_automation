package com.org.constants;

public enum Environments {
    DEV("https://backend-stage.fvhospital.com");

    private final String baseUri;

    Environments(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getBaseUri() {
        return baseUri;
    }
}

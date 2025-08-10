package com;

public class SharedTestContext {
    private static String userToken;
    private static String adminToken;
    private static String userId;
    private static String relativeId;
    private static PatientProfile patientProfile;

    private SharedTestContext() {
        // Prevent instantiation
    }

    public static String getUserToken() {
        return userToken;
    }

    public static void setUserToken(String userToken) {
        SharedTestContext.userToken = userToken;
    }

    public static String getAdminToken() {
        return adminToken;
    }

    public static void setAdminToken(String adminToken) {
        SharedTestContext.adminToken = adminToken;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        SharedTestContext.userId = userId;
    }

    public static String getRelativeId() {
        return relativeId;
    }

    public static void setRelativeId(String relativeId) {
        SharedTestContext.relativeId = relativeId;
    }

    public static PatientProfile getPatientProfile() {
        return patientProfile;
    }

    public static void setPatientProfile(PatientProfile patientProfile) {
        SharedTestContext.patientProfile = patientProfile;
    }
}

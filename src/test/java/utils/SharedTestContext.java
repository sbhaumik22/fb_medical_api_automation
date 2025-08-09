package utils;

public class SharedTestContext {
    private static String token;
    private static String userId;
    private static String relativeId;
    private static PatientProfile patientProfile;

    private SharedTestContext() {
        // Prevent instantiation
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SharedTestContext.token = token;
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

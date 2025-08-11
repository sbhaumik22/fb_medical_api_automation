package models.requests;

public class LoginPayload {
    private String phoneNumber;
    private String password;
    private String countryCode;

    // Constructors
    public LoginPayload() {
    }

    public LoginPayload(String countryCode, String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.countryCode = countryCode;
    }

    // Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

package POJOClasses;

public class SignUpPayload {
    private String firstAndMiddleName;
    private String lastName;
    private String email;
    private String alpha2code;
    private String dateOfBirth;
    private String countryCode;
    private String phoneNumber;
    private String password;
    private String passwordConfirm;
    private String gender;
    private String acceptedVersion;
    private String hnNumber;
    // private String selectedLanguage; // Uncomment if used

    // Getters and Setters
    public String getFirstAndMiddleName() {
        return firstAndMiddleName;
    }

    public void setFirstAndMiddleName(String firstAndMiddleName) {
        this.firstAndMiddleName = firstAndMiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlpha2code() {
        return alpha2code;
    }

    public void setAlpha2code(String alpha2code) {
        this.alpha2code = alpha2code;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAcceptedVersion() {
        return acceptedVersion;
    }

    public void setAcceptedVersion(String acceptedVersion) {
        this.acceptedVersion = acceptedVersion;
    }

    public String getHnNumber() {
        return hnNumber;
    }

    public void setHnNumber(String hnNumber) {
        this.hnNumber = hnNumber;
    }

    /*
    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
    */
}

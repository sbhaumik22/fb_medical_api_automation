package responseModels;

public class SignUpUser {
    private String email;
    private String countryCode;
    private SignUpCountry country;
    private String _id;
    private String profilePic;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public SignUpCountry getCountry() {
        return country;
    }

    public void setCountry(SignUpCountry country) {
        this.country = country;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}

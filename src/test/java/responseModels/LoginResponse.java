package responseModels;

public class LoginResponse {
    private String status;
    private LoginData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public static class LoginData {
        private String token;
        private LoginUser user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public LoginUser getUser() {
            return user;
        }

        public void setUser(LoginUser user) {
            this.user = user;
        }
    }

    public static class LoginUser {
        private String email;
        private String countryCode;
        private LoginCountry country;
        private String _id;
        private String profilePic;

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

        public LoginCountry getCountry() {
            return country;
        }

        public void setCountry(LoginCountry country) {
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

    public static class LoginCountry {
        private String name;
        private String alpha2code;
        private String timezone;
        private String currencyCode;
        private String currencySymbol;
        private String nationality;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlpha2code() {
            return alpha2code;
        }

        public void setAlpha2code(String alpha2code) {
            this.alpha2code = alpha2code;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public void setCurrencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }
    }


}

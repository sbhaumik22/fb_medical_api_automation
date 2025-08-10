package com.org.responseModels;

public class SignUpResponse {
    private String status;
    private SignUpData data;

    public void setStatus(String status){
        this.status = status;
    }

    public void setData(SignUpData data){
        this.data = data;
    }

    public String getStatus(){
        return status;
    }

    public SignUpData getData(){
        return data;
    }

    public static class SignUpData {
        private SignUpUser user;
        private String token;

        public void setUser(SignUpUser user) {
            this.user = user;
        }

        public SignUpUser getUser() {
            return user;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

    public static class SignUpUser {
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

    public static class SignUpCountry {
        private String _id;

        public void set_id(String _id) {
            this._id = _id;
        }

        public String get_id() {
            return this._id;
        }
    }
    
}

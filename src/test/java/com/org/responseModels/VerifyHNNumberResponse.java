package com.org.responseModels;

public class VerifyHNNumberResponse {
    private String status;
    private Data data;

    // Getters and Setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    public static class User {
        private String _id;
        private String user;
        private int __v;
        private String country;
        private String countryCode;
        private String createdAt;
        private String dateOfBirth;
        private String email;
        private boolean emailVerified;
        private String firstName;
        private String gender;
        private String hnNumber;
        private String insuranceCategory;
        private boolean isActive;
        private boolean isHNVerified;
        private String lastName;
        private String maritalStatus; // nullable
        private String patient;       // nullable
        private String phoneNumber;
        private String profilePhoto;
        private String relation;
        private String updatedAt;
        private String userVerifiedOn;

        // Getters and Setters

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHnNumber() {
            return hnNumber;
        }

        public void setHnNumber(String hnNumber) {
            this.hnNumber = hnNumber;
        }

        public String getInsuranceCategory() {
            return insuranceCategory;
        }

        public void setInsuranceCategory(String insuranceCategory) {
            this.insuranceCategory = insuranceCategory;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public boolean getIsHNVerified() {
            return isHNVerified;
        }

        public void setIsHNVerified(boolean isHNVerified) {
            this.isHNVerified = isHNVerified;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getPatient() {
            return patient;
        }

        public void setPatient(String patient) {
            this.patient = patient;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public void setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUserVerifiedOn() {
            return userVerifiedOn;
        }

        public void setUserVerifiedOn(String userVerifiedOn) {
            this.userVerifiedOn = userVerifiedOn;
        }
    }
}

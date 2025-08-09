package responseModels;

import java.util.List;

public class GetUserDetailsResponse {
    private String status;
    private GetDetailsData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetDetailsData getData() {
        return data;
    }

    public void setData(GetDetailsData data) {
        this.data = data;
    }

    public static class GetDetailsData {
        private UserProfile userProfile;
        private ProfileCompletionStatus profileCompletionStatus;
        private HnVerificationOpenRequest hnVerificationOpenRequest;
        private List<String> occupiedTags;

        public UserProfile getUserProfile() {
            return userProfile;
        }

        public void setUserProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
        }

        public ProfileCompletionStatus getProfileCompletionStatus() {
            return profileCompletionStatus;
        }

        public void setProfileCompletionStatus(ProfileCompletionStatus profileCompletionStatus) {
            this.profileCompletionStatus = profileCompletionStatus;
        }

        public HnVerificationOpenRequest getHnVerificationOpenRequest() {
            return hnVerificationOpenRequest;
        }

        public void setHnVerificationOpenRequest(HnVerificationOpenRequest hnVerificationOpenRequest) {
            this.hnVerificationOpenRequest = hnVerificationOpenRequest;
        }

        public List<String> getOccupiedTags() {
            return occupiedTags;
        }

        public void setOccupiedTags(List<String> occupiedTags) {
            this.occupiedTags = occupiedTags;
        }
    }

    public static class HnVerificationOpenRequest {
        private Relative relative;
        private Object userAddress;
        private Object nationalId;
        private List<Object> insurance;
        private String status;
        private Object rejectionReason;

        // Getters and Setters
        public Relative getRelative() {
            return relative;
        }

        public void setRelative(Relative relative) {
            this.relative = relative;
        }

        public Object getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(Object userAddress) {
            this.userAddress = userAddress;
        }

        public Object getNationalId() {
            return nationalId;
        }

        public void setNationalId(Object nationalId) {
            this.nationalId = nationalId;
        }

        public List<Object> getInsurance() {
            return insurance;
        }

        public void setInsurance(List<Object> insurance) {
            this.insurance = insurance;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRejectionReason() {
            return rejectionReason;
        }

        public void setRejectionReason(Object rejectionReason) {
            this.rejectionReason = rejectionReason;
        }
    }

    public static class ProfileCompletionStatus {
        private int completionPercentage;
        private boolean isAddedMaritalStatus;
        private boolean isVerifiedAddress;
        private boolean isVerifiedNaationalID;
        private boolean isVerifiedInsurance;
        private boolean isAddedEmergencyInfo;
        private boolean isAddedOccupation;

        // Getters and Setters
        public int getCompletionPercentage() {
            return completionPercentage;
        }

        public void setCompletionPercentage(int completionPercentage) {
            this.completionPercentage = completionPercentage;
        }

        public boolean getIsAddedMaritalStatus() {
            return isAddedMaritalStatus;
        }

        public void setIsAddedMaritalStatus(boolean isAddedMaritalStatus) {
            this.isAddedMaritalStatus = isAddedMaritalStatus;
        }

        public boolean getIsVerifiedAddress() {
            return isVerifiedAddress;
        }

        public void setIsVerifiedAddress(boolean isVerifiedAddress) {
            this.isVerifiedAddress = isVerifiedAddress;
        }

        public boolean getIsVerifiedNaationalID() {
            return isVerifiedNaationalID;
        }

        public void setVerifiedNaationalID(boolean isVerifiedNaationalID) {
            this.isVerifiedNaationalID = isVerifiedNaationalID;
        }

        public boolean getIsVerifiedInsurance() {
            return isVerifiedInsurance;
        }

        public void setIsVerifiedInsurance(boolean isVerifiedInsurance) {
            this.isVerifiedInsurance = isVerifiedInsurance;
        }

        public boolean getIsAddedEmergencyInfo() {
            return isAddedEmergencyInfo;
        }

        public void setIsAddedEmergencyInfo(boolean isAddedEmergencyInfo) {
            this.isAddedEmergencyInfo = isAddedEmergencyInfo;
        }

        public boolean getIsAddedOccupation() {
            return isAddedOccupation;
        }

        public void setIsAddedOccupation(boolean isAddedOccupation) {
            this.isAddedOccupation = isAddedOccupation;
        }
    }

    public static class UserProfile {
        private String _id;
        private String firstName;
        private String lastName;
        private String dateOfBirth;
        private String gender;
        private Country country;
        private String countryCode;
        private String phoneNumber;
        private String email;
        private boolean emailVerified;
        private boolean isHNVerified;
        private String hnNumber;
        private String maritalStatus;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
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

        public boolean getIsHNVerified() {
            return isHNVerified;
        }

        public void setIsHNVerified(boolean isHNVerified) {
            this.isHNVerified = isHNVerified;
        }

        public String getHnNumber() {
            return hnNumber;
        }

        public void setHnNumber(String hnNumber) {
            this.hnNumber = hnNumber;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }
    }

    public static class Country {
        private String nationality;

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getNationality() {
            return nationality;
        }
    }

    public static class Relative {
        private String _id;
        private String profilePhoto;
        private String firstName;
        private String lastName;
        private String dateOfBirth;
        private String gender;
        private String country;
        private String countryCode;
        private String phoneNumber;
        private String email;
        private boolean emailVerified;
        private String relation;
        private String hnNumber;
        private String maritalStatus;
        private String userVerifiedOn;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public void setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getHnNumber() {
            return hnNumber;
        }

        public void setHnNumber(String hnNumber) {
            this.hnNumber = hnNumber;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getUserVerifiedOn() {
            return userVerifiedOn;
        }

        public void setUserVerifiedOn(String userVerifiedOn) {
            this.userVerifiedOn = userVerifiedOn;
        }
    }

}
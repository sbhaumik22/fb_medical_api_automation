package models.responses;

import java.util.List;

public class GetAllInfoAboutRequestResponse {
    private String status;
    private Data data;

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

    // ===================== User Profile =====================
    public static class UserProfile {
        private String _id;
        private Country country;
        private String countryCode;
        private String dateOfBirth;
        private String email;
        private boolean emailVerified;
        private String firstName;
        private String gender;
        private String hnNumber;
        private boolean isHNVerified;
        private String lastName;
        private String maritalStatus;
        private String phoneNumber;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
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

        public boolean isHNVerified() {
            return isHNVerified;
        }
        public void setHNVerified(boolean isHNVerified) {
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

        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    public static class Country {
        private String nationality;

        public String getNationality() {
            return nationality;
        }
        public void setNationality(String nationality) {
            this.nationality = nationality;
        }
    }

    // ===================== Profile Completion Status =====================
    public static class ProfileCompletionStatus {
        private int completionPercentage;
        private boolean isAddedMaritalStatus;
        private boolean isVerifiedAddress;
        private boolean isVerifiedNaationalID;
        private boolean isVerifiedInsurance;
        private boolean isAddedEmergencyInfo;
        private boolean isAddedOccupation;

        public int getCompletionPercentage() {
            return completionPercentage;
        }
        public void setCompletionPercentage(int completionPercentage) {
            this.completionPercentage = completionPercentage;
        }

        public boolean isAddedMaritalStatus() {
            return isAddedMaritalStatus;
        }
        public void setAddedMaritalStatus(boolean addedMaritalStatus) {
            isAddedMaritalStatus = addedMaritalStatus;
        }

        public boolean isVerifiedAddress() {
            return isVerifiedAddress;
        }
        public void setVerifiedAddress(boolean verifiedAddress) {
            isVerifiedAddress = verifiedAddress;
        }

        public boolean isVerifiedNaationalID() {
            return isVerifiedNaationalID;
        }
        public void setVerifiedNaationalID(boolean verifiedNaationalID) {
            isVerifiedNaationalID = verifiedNaationalID;
        }

        public boolean isVerifiedInsurance() {
            return isVerifiedInsurance;
        }
        public void setVerifiedInsurance(boolean verifiedInsurance) {
            isVerifiedInsurance = verifiedInsurance;
        }

        public boolean isAddedEmergencyInfo() {
            return isAddedEmergencyInfo;
        }
        public void setAddedEmergencyInfo(boolean addedEmergencyInfo) {
            isAddedEmergencyInfo = addedEmergencyInfo;
        }

        public boolean isAddedOccupation() {
            return isAddedOccupation;
        }
        public void setAddedOccupation(boolean addedOccupation) {
            isAddedOccupation = addedOccupation;
        }
    }

    // ===================== HN Verification Open Request =====================
    public static class HnVerificationOpenRequest {
        private Relative relative;
        private UserAddress userAddress;
        private NationalId nationalId;
        private List<InsuranceWrapper> insurance;
        private String status;
        private String rejectionReason;

        public Relative getRelative() {
            return relative;
        }
        public void setRelative(Relative relative) {
            this.relative = relative;
        }

        public UserAddress getUserAddress() {
            return userAddress;
        }
        public void setUserAddress(UserAddress userAddress) {
            this.userAddress = userAddress;
        }

        public NationalId getNationalId() {
            return nationalId;
        }
        public void setNationalId(NationalId nationalId) {
            this.nationalId = nationalId;
        }

        public List<InsuranceWrapper> getInsurance() {
            return insurance;
        }
        public void setInsurance(List<InsuranceWrapper> insurance) {
            this.insurance = insurance;
        }

        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }

        public String getRejectionReason() {
            return rejectionReason;
        }
        public void setRejectionReason(String rejectionReason) {
            this.rejectionReason = rejectionReason;
        }
    }

    public static class Relative {
        private String _id;
        private String country;
        private String countryCode;
        private String dateOfBirth;
        private String email;
        private boolean emailVerified;
        private String firstName;
        private String gender;
        private String hnNumber;
        private String lastName;
        private String maritalStatus;
        private String phoneNumber;
        private String profilePhoto;
        private String relation;
        private String userVerifiedOn;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
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
        public String getUserVerifiedOn() {
            return userVerifiedOn;
        }
        public void setUserVerifiedOn(String userVerifiedOn) {
            this.userVerifiedOn = userVerifiedOn;
        }
    }

    public static class UserAddress {
        private String _id;
        private String city;
        private boolean defaultAddress;
        private String district;
        private String officeCountryCode;
        private String officePhoneNumber;
        private String personalCountryCode;
        private String personalPhoneNumber;
        private String postalCode;
        private String province;
        private String saveAs;
        private String street;
        private String ward;
        private String zone;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public boolean isDefaultAddress() {
            return defaultAddress;
        }
        public void setDefaultAddress(boolean defaultAddress) {
            this.defaultAddress = defaultAddress;
        }
        public String getDistrict() {
            return district;
        }
        public void setDistrict(String district) {
            this.district = district;
        }
        public String getOfficeCountryCode() {
            return officeCountryCode;
        }
        public void setOfficeCountryCode(String officeCountryCode) {
            this.officeCountryCode = officeCountryCode;
        }
        public String getOfficePhoneNumber() {
            return officePhoneNumber;
        }
        public void setOfficePhoneNumber(String officePhoneNumber) {
            this.officePhoneNumber = officePhoneNumber;
        }
        public String getPersonalCountryCode() {
            return personalCountryCode;
        }
        public void setPersonalCountryCode(String personalCountryCode) {
            this.personalCountryCode = personalCountryCode;
        }
        public String getPersonalPhoneNumber() {
            return personalPhoneNumber;
        }
        public void setPersonalPhoneNumber(String personalPhoneNumber) {
            this.personalPhoneNumber = personalPhoneNumber;
        }
        public String getPostalCode() {
            return postalCode;
        }
        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        public String getSaveAs() {
            return saveAs;
        }
        public void setSaveAs(String saveAs) {
            this.saveAs = saveAs;
        }
        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String getWard() {
            return ward;
        }
        public void setWard(String ward) {
            this.ward = ward;
        }
        public String getZone() {
            return zone;
        }
        public void setZone(String zone) {
            this.zone = zone;
        }
    }

    public static class NationalId {
        private String _id;
        private String category;
        private Images images;
        private String number;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public Images getImages() {
            return images;
        }
        public void setImages(Images images) {
            this.images = images;
        }
        public String getNumber() {
            return number;
        }
        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static class Images {
        private String back;
        private String front;

        public String getBack() {
            return back;
        }
        public void setBack(String back) {
            this.back = back;
        }
        public String getFront() {
            return front;
        }
        public void setFront(String front) {
            this.front = front;
        }
    }

    public static class InsuranceWrapper {
        private String _id;
        private String relative;
        private Insurance insurance;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }
        public String getRelative() {
            return relative;
        }
        public void setRelative(String relative) {
            this.relative = relative;
        }
        public Insurance getInsurance() {
            return insurance;
        }
        public void setInsurance(Insurance insurance) {
            this.insurance = insurance;
        }
    }

    public static class Insurance {
        private String company;
        private String image;

        public String getCompany() {
            return company;
        }
        public void setCompany(String company) {
            this.company = company;
        }
        public String getImage() {
            return image;
        }
        public void setImage(String image) {
            this.image = image;
        }
    }
}

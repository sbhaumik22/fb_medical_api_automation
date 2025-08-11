package models.requests;

public class Address {
    private String personalCountryCode;
    private String personalPhoneNumber;
    private String officeCountryCode;
    private String officePhoneNumber;
    private String street;
    private String ward;
    private String district;
    private String postalCode;
    private String city;
    private String province;
    private String saveAs;

    // Getters and Setters
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}

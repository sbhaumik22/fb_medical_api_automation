package com.org.requestPayloads;

import java.util.List;

public class CreateProfileVerificationRequestPayload {
    private PersonalInfo personalInfo;
    private Address address;
    private NationalIdentity nationalIdentity;
    private List<Insurance> insurances;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public NationalIdentity getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(NationalIdentity nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

}

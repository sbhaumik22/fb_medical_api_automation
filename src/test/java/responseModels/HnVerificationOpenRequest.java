package responseModels;

import java.util.List;

public class HnVerificationOpenRequest {
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

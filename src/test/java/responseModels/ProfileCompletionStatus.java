package responseModels;

public class ProfileCompletionStatus {
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

package responseModels;

import java.util.List;

public class GetDetailsData {
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

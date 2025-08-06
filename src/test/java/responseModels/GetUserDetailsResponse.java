package responseModels;

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
}

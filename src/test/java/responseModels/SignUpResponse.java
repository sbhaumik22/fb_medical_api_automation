package responseModels;

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
}

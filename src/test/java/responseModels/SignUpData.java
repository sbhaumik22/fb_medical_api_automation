package responseModels;

public class SignUpData {
    private SignUpUser user;
    private String token;

    public void setUser(SignUpUser user){
        this.user = user;
    }

    public SignUpUser getUser(){
        return user;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }
}

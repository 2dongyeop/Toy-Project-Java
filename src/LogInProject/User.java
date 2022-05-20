package LogInProject;

public class User {
    private String id;
    private String pswd;
    private String nickName;

    public String getId() {   //Getter
        return id;
    }
    public void setId(String id) {
        this.id = id; //Setter
    }
    public String getPswd() {   //Getter
        return pswd;
    }
    public void setPswd(String pswd) {
        this.pswd = pswd; //Setter
    }
    public String getNickName() {   //Getter
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName; //Setter
    }

}
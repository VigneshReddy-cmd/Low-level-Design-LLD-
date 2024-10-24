package model;

public class User {
    private final String Id;
    private String name;
    private String email;
    private String mobileNum;
    public String getMobileNum() {
        return mobileNum;
    }
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public User(String name, String email,String mobineNum) {
        Id =idGenerator.generateUid();
        this.name = name;
        this.email = email;
        this.mobileNum=mobineNum;
    }
    public String getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
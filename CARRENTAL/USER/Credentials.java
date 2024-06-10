package CARRENTAL.USER;

class Credentials {
    private String username;
    private String password;
    public Credentials(String username, String password)
    {
        this.username=username;
        this.password=password;

    }
    public Credentials getCredentials(){
        return new Credentials(username, password);
    }
}

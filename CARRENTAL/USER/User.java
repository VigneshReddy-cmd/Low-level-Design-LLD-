package CARRENTAL.USER;

import CARRENTAL.LOcation.Location;
import CARRENTAL.CAR.Car;
public class User  {
    String name;
    String pan_No;
    String license;
    String email;
    Car car;

    // entities
    private Location location;
    protected Credentials credentials;
    public User(String name,Location location,String email,String pan_No,String license){
        this.location=location;
        this.name=name;
        this.email=email;
        this.pan_No=pan_No;
        this.license=license;
        car=null;
    }
    public User(String username,String password){

        this.credentials=new Credentials(username, password);
    }
    public Location geLocation(){
        return location;
    }
}

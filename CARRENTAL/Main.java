package CARRENTAL;

import CARRENTAL.LOcation.Lattitude;
import CARRENTAL.LOcation.Location;
import CARRENTAL.LOcation.Longitude;
import CARRENTAL.USER.User;
import CARRENTAL.CAR.Car;

public class Main {
    public static void main(String[] args) {
        Longitude lot=new Longitude("29.234.45.6.7");
        Lattitude lt=new Lattitude("23.4445.765.2");
        Location location1=new Location("MOULA-ALI", "500040",lot.getLongitude(),lt.getlattitude());
        Location location2=new Location("MOULA-ALI", "500040",lot.getLongitude(),lt.getlattitude());
        User p1;
        User p2;
        p1=new User("Vignesh", location1, "lvreddy@gmail.com", "Frcpr3057K", "Jgpts678");
        p2=new User("nani", location2, "nani@gmail.com", null, null);
        p1=new User("Vigneshreddy", "Vignesh(!&&&&)");
        p2=new User("NaniReddy", "Nani(!&&&&)");
        Car car=getCar(p1);
    }
    private static Car getCar(User p1){
        // this is returend from db
      return new Car();
    }
}

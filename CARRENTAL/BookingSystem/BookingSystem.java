package CARRENTAL.BookingSystem;

import java.util.ArrayList;
import java.util.HashMap;

import CARRENTAL.CAR.Car;
import CARRENTAL.CAR.Fuel;
import CARRENTAL.CAR.SEAT;
import CARRENTAL.CAR.Type;
import CARRENTAL.LOcation.Location;
import CARRENTAL.USER.User;

public class BookingSystem {
    private ArrayList<Car> list_cars;
    private ArrayList<User> list_users;
    private ArrayList<Location> list_Locations;
    private HashMap<Car, Boolean> car_Check;
    private HashMap<Location, ArrayList<Car>> map_loc_car;
    private HashMap<Type, ArrayList<Car>> map_type_car;
    private HashMap<Fuel, ArrayList<Car>> map_fuel_car;
    private HashMap<Integer, ArrayList<Car>> map_price_car;
    private HashMap<SEAT, ArrayList<Car>> map_seat_car;
    public Car car;
    public User user;

    // the above lists are already filled by the opearator and chenged as per
    // requirements runtime
    public BookingSystem(Car car, User user) {
        this.user = user;
        this.car = car;
        
    }

    public ArrayList<Car> getCarBYLocation(Location location) {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : map_loc_car.get(location)) {
            if (!car_Check.get(car)) {
                list.add(car);
            }
        }
        return list;
    }

    public ArrayList<Car> getCarByTypeL(Type type) {
        ArrayList<Car> list = new ArrayList<>();
        for (Car car : map_type_car.get(type)) {
            if (!car_Check.get(car)) {
                list.add(car);
            }
        }
        return list;
    }
    // similar functions for all the filters

    public Invoices Booking_car(Reserve reserve) {
        if (!car_Check.get(reserve.car)) {
            return null;
        }
         car_Check.put(car, true);
         return new Invoices(reserve.pick,reserve.drop, 0);
    }
    public String get_Notification(){
        return "YOUR CAR IS BOOKED";
    }
}

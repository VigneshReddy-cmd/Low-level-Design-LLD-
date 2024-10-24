package BOOKMYSHOW.Cinema;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ATM.Address;

public class CinemaHall {
    String ID;
    String Name;
    Address address;
    List<Audi> audiList;
    //API - 1 
    Map<Date,Movie> getMovies(List<Date> dates){
        // get movies based on the date and movie released
        Map<Date,Movie> movieDateMap=new HashMap<>();
        return movieDateMap;
    }

    //API - 2
    Map<Date,Show> getShows(List<Date> dates)
    {
        // get showa by date
        Map<Date,Show> showsDateMap=new HashMap<>();
        return showsDateMap;
    }
}

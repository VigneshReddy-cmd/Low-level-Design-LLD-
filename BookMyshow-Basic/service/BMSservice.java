import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import BOOKMYSHOW.Cinema.CinemaHall;
import BOOKMYSHOW.Cinema.Movie;

public class BMSservice {
    List<CinemaHall> cinemas;
    // based on movie date and the city and movies Avaliable
    List<Movie> getMovies(Date date,String city)
    {
        List<Movie> movieList=new ArrayList<>();
        return movieList;
    }
    // based on the city returns the Cinemahalls
    List<CinemaHall> getCinemaHalls(String city)
    {
        List<CinemaHall> cinemaHallsList=new ArrayList<>();
        return cinemaHallsList;
    }
}

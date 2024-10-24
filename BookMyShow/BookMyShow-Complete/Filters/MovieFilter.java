package Filters;

import java.util.List;
import java.util.stream.Collectors;

import model.Show;

public class MovieFilter implements Filter{
    private final String movieTitle;

    public MovieFilter(String movieTitle)
    {
        this.movieTitle=movieTitle;
    }

    /**
     * @param shows
     * all shows
     * @return
     * retusns the filtered shows on movie name
     */
    @Override
    public List<Show> filter(List<Show> shows)
    {
       return shows.stream()
             .filter(show->show.getMovie().getTitle().equals(movieTitle))
             .collect(Collectors.toList());
    }
}

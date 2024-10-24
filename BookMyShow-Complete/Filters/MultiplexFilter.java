package Filters;

import java.util.List;
import java.util.stream.Collectors;

import model.Show;

public class MultiplexFilter implements Filter {
    private final String multiplexName;

    public MultiplexFilter(String multiplexName)
    {
        this.multiplexName=multiplexName;
    }

     /**
     * @param shows
     * all shows
     * @return
     * retusns the filtered shows on multiplex
     */
    @Override
    public List<Show> filter(List<Show> shows)
    {
       return shows.stream()
             .filter(show->show.getScreen().getMultiplex().getName().equals(multiplexName))
             .collect(Collectors.toList());
    }
}

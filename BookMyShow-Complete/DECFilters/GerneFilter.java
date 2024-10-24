package DECFilters;

import java.util.List;
import java.util.stream.Collectors;

import model.Show;

public class GerneFilter extends FilterDecerator
{
    private final String gerne;

    public GerneFilter(String gerne, ShowFilter filter) {
        super(filter);
        this.gerne = gerne;
    }

    public GerneFilter(String gerne) {
        super(null);
        this.gerne = gerne;
    }

    @Override
    public List<Show> apply(List<Show> shows) {
        shows=super.apply(shows);
        
        return shows.stream()
               .filter(show->show.getMovie().getGerne().equals(gerne))
               .collect(Collectors.toList());
    }
}

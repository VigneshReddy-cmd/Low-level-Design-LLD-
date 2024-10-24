package DECFilters;

import java.util.List;
import java.util.stream.Collectors;

import model.Show;

public class LocationFilter extends FilterDecerator {
    private final String location;


    public LocationFilter(String location) {
        super(null);
        this.location = location;
    }

    public LocationFilter(String location,ShowFilter filter) {
        super(filter);
        this.location = location;
    }

    @Override
    public List<Show> apply(List<Show> shows) {
        shows=super.apply(shows);

        return shows.stream()
               .filter(show->show.getScreen().getMultiplex().getLocation().equals(location))
               .collect(Collectors.toList());
    }
}

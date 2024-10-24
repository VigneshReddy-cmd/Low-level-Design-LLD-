package DECFilters;

import java.util.List;

import model.Show;

public class FilterDecerator implements ShowFilter {

    private final ShowFilter filter;

    public FilterDecerator(ShowFilter filter)
    {
        this.filter=filter;
    }

    @Override
    public List<Show> apply(List<Show> shows) {
        return (filter != null) ? filter.apply(shows) : shows;
    }

}

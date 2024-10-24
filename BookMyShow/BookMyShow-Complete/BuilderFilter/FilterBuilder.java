package BuilderFilter;

import DECFilters.GerneFilter;
import DECFilters.LocationFilter;
import DECFilters.ShowFilter;

public class FilterBuilder {
    private ShowFilter filter;

    public FilterBuilder genre(String genre) {
        this.filter = new GerneFilter(genre, filter);
        return this;
    }

    public FilterBuilder location(String location) {
        this.filter = new LocationFilter(location, filter);
        return this;
    }

    public ShowFilter build() {
        return filter;
    }
}

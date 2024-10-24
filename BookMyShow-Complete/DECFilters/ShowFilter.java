package DECFilters;

import java.util.List;

import model.Show;

public interface ShowFilter {
    public List<Show> apply(List<Show> shows);
}

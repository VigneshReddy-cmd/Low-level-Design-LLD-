package sorter;

import java.util.List;

import model.Show;

public class SorterManager {
    private final SortingStartegy sortingStartegy;

    public SorterManager(SortingStartegy sortingStartegy) {
        this.sortingStartegy = sortingStartegy;
    }

    public List<Show> getSortShows(List<Show> shows)
    {
        return sortingStartegy.sort(shows);
    }

    public SortingStartegy getSortingStartegy() {
        return sortingStartegy;
    }

}

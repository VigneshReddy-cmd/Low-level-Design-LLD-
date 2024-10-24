package sorter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Show;

public class CheapestShowSorter implements SortingStartegy {

    @Override
    public List<Show> sort(List<Show> shows) {
        return shows.stream()
               .sorted(Comparator.comparingDouble(Show::getShowPrice))
               .collect(Collectors.toList());
    }

}

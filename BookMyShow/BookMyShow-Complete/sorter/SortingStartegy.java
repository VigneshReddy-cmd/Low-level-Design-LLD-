package sorter;

import java.util.List;

import model.Show;

public interface SortingStartegy {
    
    List<Show> sort(List<Show> shows);
}

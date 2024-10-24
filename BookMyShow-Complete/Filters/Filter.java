package Filters;

import java.util.List;

import model.Show;

public interface Filter {

    public List<Show> filter(List<Show> show);
}

package Filters;

import java.util.List;

import model.Show;

public class FilterManager {
    private  Filter filterStatargy;

    // 2ways  using constructor other is using setter method.

    
    public Filter getFilter() {
        return filterStatargy;
    }

    public void setFilter(Filter filterStatargy) {
        this.filterStatargy= filterStatargy;
    }

    public List<Show> applyFilter(List<Show> shows)
    {
        if(filterStatargy==null)
        {
            throw new IllegalStateException("No filter set");
        }
        return filterStatargy.filter(shows);
    }
}

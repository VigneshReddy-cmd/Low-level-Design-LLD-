package model;

import java.util.ArrayList;
import java.util.List;

public class Multiplex {
    private final String Id;

    private String name;

    private String location;

    private List<Screen> screens;

    public Multiplex(String name, String location) {
        Id=idGenerator.generateUid();
        this.name = name;
        this.location = location;
        screens=new ArrayList<>();
    }

    public void addScreens(Screen screen)
    {
        System.out.println(screen.getName()+"added to"+this.getName());
        screens.add(screen);
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screen> getScreens() {
        return screens;
    }
    
}

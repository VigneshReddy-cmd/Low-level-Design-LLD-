package model;

public class Movie {
    private final String Id;

    private String title;

    private String language;

    private String gerne;

    private String releaseDate;

    private int runTime;

    public Movie(String title, String language, String gerne, String releaseDate, int runTime) {
        Id = idGenerator.generateUid();
        this.title = title;
        this.language = language;
        this.gerne = gerne;
        this.releaseDate = releaseDate;
        this.runTime = runTime;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGerne() {
        return gerne;
    }

    public void setGerne(String gerne) {
        this.gerne = gerne;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    
}

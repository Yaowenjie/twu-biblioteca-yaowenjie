package entity;

/**
 * Created by admin on 2015/7/26.
 */
public class Movie extends Item{
    private String director;
    private String rating;

    public Movie(String name, String director, String year, String rating, boolean isAvailable) {
        super(name, year, isAvailable);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

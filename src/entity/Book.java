/**
 * Created by admin on 2015/7/25.
 */
package entity;

public class Book extends Item{
    private String authors;

    public Book(String name, String authors, String year, boolean isAvailable) {
        super(name, year, isAvailable);
        this.authors = authors;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }



}

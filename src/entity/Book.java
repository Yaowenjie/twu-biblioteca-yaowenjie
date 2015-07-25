/**
 * Created by admin on 2015/7/25.
 */
package entity;

public class Book {
    private String name;
    private String authors;
    private String publishedYear;
    private boolean isAvailable;

    public Book(String name, String authors, String publishedYear, boolean isAvailable) {
        this.name = name;
        this.authors = authors;
        this.publishedYear = publishedYear;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

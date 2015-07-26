package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/7/26.
 */
public class ItemList {
    public List<Book> bookList = new ArrayList<Book>();
    public List<Movie> movieList = new ArrayList<Movie>();


    public void addToBookList(Book book) {
        this.bookList.add(book);
    }

    public void addToMovieList(Movie movie) {
        this.movieList.add(movie);
    }

    public void listAllItems(String type) {
        if (type.equals("book")) {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Book Details^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            for (Book book : bookList) {
                if (book.isAvailable())
                    System.out.println("*   Name: " + book.getName()
                            + "  |   Authors: " + book.getAuthors()
                            + "  |   Published Year: " + book.getYear());
            }
        } else if (type.equals("movie")) {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Movie Details^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            for (Movie movie : movieList) {
                if (movie.isAvailable())
                    System.out.println("Name: " + movie.getName()
                            + "| Director: " + movie.getDirector()
                            + "| Year: " + movie.getYear()
                            + "| Rating:" + movie.getRating());
            }
        }
    }

    public void checkoutFromList(String type, String name) {
        boolean isCheckouted = false;
        if (type.equals("book")) {
            for (Book book : this.bookList) {
                isCheckouted = book.checkoutItem("book", name);
                if (isCheckouted) break;
            }
        } else if (type.equals("movie")) {
            for (Movie movie : this.movieList) {
                isCheckouted = movie.checkoutItem("movie", name);
                if (isCheckouted) break;
            }
        }
        if (!isCheckouted) System.out.println("That " + type + " is not available.");
    }

    public void returnToList(String type, String name) {
        boolean isReturned = false;
        if (type.equals("book")) {
            for (Book book : this.bookList) {
                isReturned = book.returnItem("book", name);
                if (isReturned) break;
            }
        } else if (type.equals("movie")) {
            for (Movie movie : this.movieList) {
                isReturned = movie.returnItem("movie", name);
                if (isReturned) break;
            }
        }
        if (!isReturned) System.out.println("That is not a valid "+type+" to return.");
    }


}
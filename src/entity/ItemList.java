package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/7/26.
 */
public class ItemList {
    public List<Book> bookList = new ArrayList<Book>();
    public List<Movie> movieList = new ArrayList<Movie>();
    public List<User> userList = new ArrayList<User>();
    public User currentUser = null;

    public void addToBookList(Book book) {
        this.bookList.add(book);
    }

    public void addToMovieList(Movie movie) {
        this.movieList.add(movie);
    }
    public void addToUserList(User user) {
        this.userList.add(user);
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
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Movie Details^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            for (Movie movie : movieList) {
                if (movie.isAvailable())
                    System.out.println("*   Name: " + movie.getName()
                            + "  |  Director: " + movie.getDirector()
                            + "  |  Year: " + movie.getYear()
                            + "  |  Rating:" + movie.getRating());
            }
        }
    }

    public void checkoutFromList(String type, String name) {
        boolean isCheckouted = false;
        if (type.equals("book")) {
            for (Book book : this.bookList) {
                isCheckouted = book.checkoutItem("book", name);
                if (isCheckouted) {
                    book.setOwner(currentUser);
                    break;
                }
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
                if (isReturned) {
                    book.setOwner(null);
                    break;
                }
            }
        } else if (type.equals("movie")) {
            for (Movie movie : this.movieList) {
                isReturned = movie.returnItem("movie", name);
                if (isReturned) break;
            }
        }
        if (!isReturned) System.out.println("That is not a valid "+type+" to return.");
    }

    public User loginFromList(String libNum,String libPw){
        for (User user:this.userList){
            if(user.isLogin(libNum,libPw)){
                System.out.println();
                return user;
            }
        }
        return null;
    }

    public void listAllInfo() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Book Details^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (Book book : bookList) {
            System.out.print("*   Name: " + book.getName()
                            + "  |   Authors: " + book.getAuthors()
                            + "  |   Published Year: " + book.getYear());
            if(book.getOwner()!=null){
                System.out.print("  |  Owner name:" + book.getOwner().getName()
                                + " |lib num:" + book.getOwner().getLibNumber()
                                + " |email:" + book.getOwner().getEmailAddress()
                                + " |phone:" + book.getOwner().getPhoneNumber()
                );
            }
            System.out.println("");
        }
    }
}
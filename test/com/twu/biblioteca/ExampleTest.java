package com.twu.biblioteca;


import entity.Book;
import org.junit.Test;
import static com.twu.biblioteca.BibliotecaApp.*;


public class ExampleTest {

    @Test
    public void should_see_welcomeMessage(){
        welcomeMessage();
    }

    @Test
    public void should_list_all_books_details() {
        booklist.add(new Book("Java", "Zhangyu", "2015", true));
        booklist.add(new Book("spring", "YWJ", "2015", true));
        booklist.add(new Book("Eat", "Dog", "2015", true));
        listAllBooks();
    }

    @Test
    public void should_see_main_menu() throws Exception {
        mainMenu();
    }

    @Test
    public void should_see_booklists_when_enter_1_in_mainMenu() throws Exception {
       mainMenuOptions(1);
    }

    @Test
    public void should_quit_when_enter_2_in_mainMenu() throws Exception {
        mainMenuOptions(2);
    }

    @Test
    public void shoule_prompt_invalid_when_enter_3_in_mainMenu() throws Exception {
        mainMenuOptions(3);
    }

    @Test
    public void should_checkout_book_by_name_Java() throws Exception {
        booklist.add(new Book("Java", "Zhangyu", "2015", true));
        booklist.add(new Book("spring", "YWJ", "2015", true));
        booklist.add(new Book("Eat", "Dog", "2015", true));
        checkoutBooks("Java");
    }

    @Test
    public void should_prompt_unavailable_when_checkout_book_twice_by_name_Java() throws Exception {
        booklist.add(new Book("Java", "Zhangyu", "2015", true));
        booklist.add(new Book("spring", "YWJ", "2015", true));
        booklist.add(new Book("Eat", "Dog", "2015", true));
        checkoutBooks("Java");
        checkoutBooks("Java");
    }

    @Test
    public void should_see_checkoutMenu() throws Exception {
        checkoutMenu();
    }

    @Test
    public void should_checkout_book_when_enter_1_in_checkoutMenuOptions() throws Exception {
        booklist.add(new Book("Java", "Zhangyu", "2015", true));
        booklist.add(new Book("spring", "YWJ", "2015", true));
        booklist.add(new Book("Eat", "Dog", "2015", true));
        checkoutName = "Java";
        checkoutMenuOptions(1);
    }
}

package com.twu.biblioteca;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    public static List<Book> booklist = new ArrayList<Book>();
    private static boolean isQuit=false;

    public static void main(String[] args) {
        booklist.add(new Book("Java", "Zhangyu", "2015", true));
        booklist.add(new Book("spring", "YWJ", "2015", true));
        booklist.add(new Book("Eat", "Dog", "2015", true));
        welcomeMessage();
        mainMenu();
    }

    public static void welcomeMessage() {
        System.out.println("*****************************");
        System.out.println("  Welcome to BibliotecaApp");
        System.out.println(" Library Management System  ");
    }

    public static void listAllBooks() {
        for (Book book:booklist){
            if(book.isAvailable()){
                System.out.println("^^^^^^^^^^^Book Details^^^^^^^^^^^");
                System.out.println("Name: "+book.getName());
                System.out.println("Authors: "+book.getAuthors());
                System.out.println("Published Year: "+book.getPublishedYear());
            }
        }
        pageMenu();
    }

    public static void mainMenu(){
        System.out.println("---------------------------");
        System.out.println("- 1.List Books            -" );
        System.out.println("- 2 Checkout Books        -" );
        System.out.println("- 3 Return Books        -" );
        System.out.println("- 6.Quit                  -" );
        System.out.println("---------------------------");
        System.out.println("Please enter your option:");

        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                listAllBooks();
                break;
            case 2:
                inoutMenu("out");
                break;
            case 3:
                inoutMenu("in");
                break;
            case 6:
                isQuit = true;
                break;
            default:
                System.out.println("Select a valid option!");
                mainMenu();
                break;
        }
    }

    public static void inoutMenu(String inout) {
        System.out.println("------------------------------");
        System.out.println("- 1.Enter the name of book   -");
        System.out.println("- 2.Return to main menu      -");
        System.out.println("- 3.Quit                     -");
        System.out.println("------------------------------");
        System.out.println("Please enter your option:");
        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                System.out.println("Input your book name:");
                if (inout.equals("in")) returnBooks(getInputString());
                else checkoutBooks(getInputString());
                break;
            case 2:
                mainMenu();
                break;
            case 3:
                isQuit = true;
                break;
            default:
                System.out.println("Select a valid option!");
                inoutMenu(inout);
                break;
        }
    }

    public static void pageMenu() {
        System.out.println("------------------------------");
        System.out.println("- 1.Return to main menu      -");
        System.out.println("- 2.Quit                     -");
        System.out.println("------------------------------");
        System.out.println("Please enter your option:");
        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                mainMenu();
                break;
            case 2:
                isQuit = true;
                break;
            default:
                System.out.println("Select a valid option!");
                pageMenu();
                break;
        }
    }

     private static String getInputNum() {
         Scanner scan = new Scanner(System.in);
         String line = scan.nextLine();
         if (!line.matches("[0-9]|[1-9][0-9]+"))
         {
             System.out.println("Select a valid option!");
             line = getInputNum();
         }
         while(line==null){}
         return line;
    }

    private static String getInputString() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(line==null){}
        return line;
    }

    public static void checkoutBooks(String name) {
        boolean isCheckouted = false;
        for (Book book:booklist){
            if(book.isAvailable() && name.equals(book.getName())){
                book.setIsAvailable(false);
                System.out.println("Thank You! Enjoy the book!");
                isCheckouted = true;
                break;
            }
        }
        if(!isCheckouted) System.out.println("That book is not available.");
        inoutMenu("out");
    }

    private static void returnBooks(String name) {
        boolean isReturned = false;
        for (Book book:booklist){
            if((!book.isAvailable()) && name.equals(book.getName())){
                book.setIsAvailable(true);
                System.out.println("Thank you for returning the book!");
                isReturned = true;
                break;
            }
        }
        if(!isReturned) System.out.println("That is not a valid book to return.");
        inoutMenu("in");
    }
}

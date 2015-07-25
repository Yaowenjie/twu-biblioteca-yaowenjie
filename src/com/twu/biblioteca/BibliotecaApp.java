package com.twu.biblioteca;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entity.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static List<Book> booklist = new ArrayList<Book>();

    private static boolean isQuit=false;
    public static String checkoutName;

    public static void main(String[] args) {
        welcomeMessage();
        while(!isQuit) {
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            mainMenu();
        }
    }

    public static void welcomeMessage() {
        System.out.println("*****************************");
        System.out.println("  Welcome to BibliotecaApp");
        System.out.println(" Library Management System  ");
        System.out.println("*****************************");
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

    }

    public static void mainMenu(){
        System.out.println("---------------------------");
        System.out.println("- 1.List Books            -" );
        System.out.println("- 6.Quit                  -" );
        System.out.println("---------------------------");
        System.out.println("Please enter your option:");
    }

    public static void mainMenuOptions(int option) {
        switch (option) {
            case 1:
                listAllBooks();
                break;
            case 6:
                isQuit = true;
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    public static void checkoutMenu() {
        System.out.println("---------------------------");
        System.out.println("- 1.check out books       -");
        System.out.println("- 2.return to main menu   -");
        System.out.println("- 3.quit                  -");
        System.out.println("---------------------------");
        System.out.println("Please enter your option:");
    }

    public static void checkoutMenuOptions(int option){
        switch (option) {
            case 1:
//                intoCheckout();
//                System.out.println("Please input name:");
                checkoutBooks(checkoutName);
                break;
            case 2:
                mainMenu();
                break;
            case 3:
                isQuit = true;
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

     private static String getInputText() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(line==null){}
        return line;
    }


    public static void checkoutBooks(String name) {
        System.out.println("Input your book name:");
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
    }
}

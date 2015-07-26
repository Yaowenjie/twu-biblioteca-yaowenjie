package com.twu.biblioteca;

import entity.Book;
import entity.ItemList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static ItemList itemList = new ItemList();

    public static void main(String[] args) {
        itemList.addToBookList(new Book("Java", "Zhangyu", "2015", true));
        itemList.addToBookList(new Book("spring", "YWJ", "2015", true));
        itemList.addToBookList(new Book("Eat", "Dog", "2015", true));
        welcomeMessage();
        mainMenu();
    }

    public static void welcomeMessage() {
        System.out.println("*****************************");
        System.out.println("  Welcome to BibliotecaApp");
        System.out.println(" Library Management System  ");
    }

    public static void mainMenu() {
        System.out.println("---------------------------");
        System.out.println("- 1.List Books            -");
        System.out.println("- 2 Checkout Books        -");
        System.out.println("- 3 Return Books        -");
        System.out.println("- 7.Quit                  -");
        System.out.println("---------------------------");
        System.out.println("Please enter your option:");

        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                itemList.listAllItems("book");
                pageMenu();
                break;
            case 2:
                inoutMenu("out");
                break;
            case 3:
                inoutMenu("in");
                break;
            case 7:
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
        System.out.println("- 7.Quit                     -");
        System.out.println("------------------------------");
        System.out.println("Please enter your option:");
        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                System.out.println("Input your book name:");
                if (inout.equals("in")) {
                    itemList.returnToList("book",getInputString());
                    inoutMenu("in");
                }
                else{
                    itemList.checkoutFromList("book",getInputString());
                    inoutMenu("out");
                }
                break;
            case 2:
                mainMenu();
                break;
            case 7:
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
        System.out.println("- 7.Quit                     -");
        System.out.println("------------------------------");
        System.out.println("Please enter your option:");
        int option = Integer.parseInt(getInputNum());
        switch (option) {
            case 1:
                mainMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("Select a valid option!");
                pageMenu();
                break;
        }
    }

    private static String getInputNum() {
        String line = (new Scanner(System.in)).nextLine();
        if (!line.matches("[0-9]|[1-9][0-9]+")) {
            System.out.println("Select a valid option!");
            line = getInputNum();
        }
        while (line == null) {
        }
        return line;
    }

    private static String getInputString() {
        String line = (new Scanner(System.in)).nextLine();
        while (line == null) {
        }
        return line;
    }

}

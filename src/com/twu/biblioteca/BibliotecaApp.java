package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
        menuOptions();
    }

    public static boolean welcomeMessage() {
        System.out.println("-----------------------------");
        System.out.println("  Welcome to BibliotecaApp");
        System.out.println(" Library Management System  ");
        System.out.println("-----------------------------");
        return true;
    }

    public static void menuOptions() {
        System.out.println("***************************");
        System.out.println("* 1.List Books            *" );
        System.out.println("***************************");
    }
}

package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
        menuOptionsPrompt();

    }

    public static void welcomeMessage() {
        System.out.println("*****************************");
        System.out.println("  Welcome to BibliotecaApp");
        System.out.println(" Library Management System  ");
        System.out.println("*****************************");
    }

    public static void menuOptionsPrompt() {
        System.out.println("---------------------------");
        System.out.println("- 1.List Books            -" );
        System.out.println("- 2.Quit                  -" );
        System.out.println("---------------------------");
        System.out.println("Please enter your option:");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option) {
            case 1:
                System.out.println("1111");
                break;
            case 2:
                System.out.println("222");
                break;
            default:;
        }
    }
}

package pl.gornik;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Restaurant Management");
        System.out.println("Choose what you want to see.");
        System.out.println("-------------------------------------");
        System.out.println("1. Personnel Management");
        System.out.println("2. Income/Expenses Management");
        System.out.println("3. Menu Management");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------");
        int choice_menu = scanner.nextInt();

        switch(choice_menu) {
            case 1:
                personnelManagement();
                break;
            case 2:
                System.out.println("-------------------------------------");
                System.out.println("1. Income Management");
                System.out.println("2. Expenses Management");
                System.out.println("-------------------------------------");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> incomeManagement();
                    case 2 -> expensesManagement();
                }
                break;
            case 3:

        }

    }

    public static void personnelManagement() {

    }

    public static void  incomeManagement() {

    }

    public static void expensesManagement() {

    }
}
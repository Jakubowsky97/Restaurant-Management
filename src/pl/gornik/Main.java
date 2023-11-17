package pl.gornik;

import pl.gornik.staff.Kitchen;
import pl.gornik.staff.Waiters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Staff> Workers = new ArrayList<>();
        List<Menu> MenuList = new ArrayList<>();

        Workers.add(new Kitchen(0, "Adrianna", "Nowak", 31, 3182.00, "Cook", "NowakAdrianna@gmail.com", LocalDate.of(2017, 2, 20), 8));
        Workers.add(new Kitchen(1, "Eric", "Williams", 25, 3040.00, "Cook", "EricMWilliams@teleworm.us", LocalDate.of(2020, 6, 13), 3));
        Workers.add(new Kitchen(2, "Bartłomiej", "Zając", 41, 5698.00, "Executive chief", "BartlomiejZajac@dayrep.com", LocalDate.of(2015, 6, 13), 15));
        Workers.add(new Kitchen(3, "Jowita", "Grabowska", 36, 4532.00, "Sous chief", "JowitaGrabowska@jourrapide.com", LocalDate.of(2016, 12, 6), 12));
        Workers.add(new Waiters(4, "Arcangelo", "Russo", 22, 2215.00, "Server", "ArcangeloRusso@armyspy.com", LocalDate.of(2021, 4, 18), 50));
        Workers.add(new Waiters(5, "Mattalic", "Twofoot", 24, 2542.00, "Host", "MattalicTwofoot@wp.com", LocalDate.of(2019, 1, 30), 54));
        Workers.add(new Waiters(6, "Ayrton", "Malave", 19, 2100.00, "Trainee", "AyrtonTelloMalave@jourrapide.com", LocalDate.of(2022, 5, 15), 35));
        Workers.add(new Waiters(7, "David", "Schmitz", 47, 2100.00, "Head waiter", "DavidSchmitz@armyspy.com", LocalDate.of(2015, 4, 2), 76));








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
                System.out.println("Your staff: ");
                for (Staff worker : Workers) {
                    System.out.println(worker.displayStaff());
                }
                System.out.println("-------------------------------------");
                System.out.println("1. Add new staff");
                System.out.println("2. Fire staff");
                System.out.println("-------------------------------------");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addStaff();
                    case 2 -> fireStaff();
                }
                break;
            case 2:
                System.out.println("-------------------------------------");
                System.out.println("1. Income Management");
                System.out.println("2. Expenses Management");
                System.out.println("-------------------------------------");
                int choice_2 = scanner.nextInt();
                switch (choice_2) {
                    case 1 -> incomeManagement();
                    case 2 -> expensesManagement();
                }
                break;
            case 3:

        }

    }

    public static void addStaff() {

    }

    public static void fireStaff() {

    }

    public static void  incomeManagement() {

    }

    public static void expensesManagement() {

    }
}
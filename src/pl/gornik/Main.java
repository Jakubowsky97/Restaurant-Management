package pl.gornik;

import pl.gornik.food.Drinks;
import pl.gornik.food.meals;
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
        List<Income> Income = new ArrayList<>();
        List<Expenses> Expense = new ArrayList<>();

        //dodawanie 8 pracowników do listy Workers.
        Workers.add(new Kitchen(0, "Adrianna", "Nowak", 31, 3182.00, "Cook", "NowakAdrianna@gmail.com", LocalDate.of(2017, 2, 20), 8));
        Workers.add(new Kitchen(1, "Eric", "Williams", 25, 3040.00, "Cook", LocalDate.of(2020, 6, 13), 3));
        Workers.add(new Kitchen(2, "Bartłomiej", "Zając", 41, 5698.00, "Executive chief", "BartlomiejZajac@dayrep.com", LocalDate.of(2015, 6, 13), 15));
        Workers.add(new Kitchen(3, "Jowita", "Grabowska", 36, 4532.00, "Sous chief", "JowitaGrabowska@jourrapide.com", LocalDate.of(2016, 12, 6), 12));
        Workers.add(new Waiters(4, "Arcangelo", "Russo", 22, 2215.00, "Server", "ArcangeloRusso@armyspy.com", LocalDate.of(2021, 4, 18), 50));
        Workers.add(new Waiters(5, "Mattalic", "Twofoot", 24, 2542.00, "Host", "MattalicTwofoot@wp.com", LocalDate.of(2019, 1, 30), 54));
        Workers.add(new Waiters(6, "Ayrton", "Malave", 19, 2100.00, "Trainee", LocalDate.of(2022, 5, 15), 35));
        Workers.add(new Waiters(7, "David", "Schmitz", 47, 3417.00, "Head waiter", "DavidSchmitz@armyspy.com", LocalDate.of(2015, 4, 2), 76));

        //Dodawanie 10-ciu opcji w menu.
        MenuList.add(new Drinks(0, "Caffe Latte", 3.65, "Coffee", true));
        MenuList.add(new Drinks(1, "Earl Grey", 4.34, "Tea", true));
        MenuList.add(new Drinks(2, "Coca Cola", 2.50, "Soft drinks", false));
        MenuList.add(new Drinks(3, "Fanta", 2.15, "Soft drinks", false));
        MenuList.add(new Drinks(4, "Bubble Tea", 5.25, "Iced tea", false));
        MenuList.add(new meals(5, "Fries", 2.49, "Side dish", 311));
        MenuList.add(new meals(6, "Cheese Burger", 3.79, "Sandwiches", 434));
        MenuList.add(new meals(7, "Pizza with salami", 10.89, "Pizza", 2505));
        MenuList.add(new meals(8, "Tiramisu", 8.49, "Dessert", 616));
        MenuList.add(new meals(9, "Ice Cream", 1.49, "Dessert", 252));

        //Dodawanie Income

        Scanner scanner = new Scanner(System.in);

        //pierwsze menu w którym użytkownik może wybrac co chce zrobić. Program zakończy zadanie wyłącznie wtedy kiedy wpisze 4
        int choice_menu = 0;
        while (choice_menu != 4) {
            displayMainMenu();

            choice_menu = scanner.nextInt();

            switch (choice_menu) {
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
                        case 1 -> Staff.addStaff(Workers);
                        case 2 -> Staff.fireStaff(Workers);
                    }
                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println("1. Income Management");
                    System.out.println("2. Expenses Management");
                    System.out.println("-------------------------------------");
                    int choice_income = scanner.nextInt();
                    switch (choice_income) {
                        case 1 -> incomeManagement();
                        case 2 -> expensesManagement();
                    }
                    break;
                case 3:
                    System.out.println("Menu: ");
                    for (Menu menu : MenuList) {
                        System.out.println(menu.displayMenu());
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("1. Add new item to menu.");
                    System.out.println("2. Change existing menu.");
                    System.out.println("3. Remove items from existing menu.");
                    System.out.println("-------------------------------------");
                    int choice_menuList = scanner.nextInt();
                    switch (choice_menuList) {
                        case 1 -> Menu.addItem(MenuList);
                        //case 2 -> Menu.changeItem(MenuList);
                        case 3 -> Menu.removeItem(MenuList);
                    }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("Restaurant Management");
        System.out.println("Choose what you want to see.");
        System.out.println("-------------------------------------");
        System.out.println("1. Personnel Management");
        System.out.println("2. Income/Expenses Management");
        System.out.println("3. Menu Management");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------");
    }

    public static void incomeManagement() {

    }

    public static void expensesManagement() {

    }
<<<<<<< HEAD
=======

    public static void changeItem(List<Menu> MenuList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select name of item.");

        String nameOfChoice = scanner.next();

        for (Menu menu : MenuList) {
            if(menu.getMenuItem().equalsIgnoreCase(nameOfChoice)) {
                System.out.println("What do you want to change?");
                System.out.println("1. Name Of Product");
                System.out.println("2. Price");
                System.out.println("3. Type");
                //if()
            }

        }
    }
>>>>>>> 347f7dfcd9210855cbc6bcbd871b8a0c0cf3f970
}
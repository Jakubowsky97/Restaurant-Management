package pl.gornik;

import pl.gornik.food.Drinks;
import pl.gornik.food.meals;
import pl.gornik.staff.Kitchen;
import pl.gornik.staff.Waiters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Staff> Workers = new ArrayList<>();
        List<Menu> MenuList = new ArrayList<>();
        List<Income> IncomeList = new ArrayList<>();
        List<Expenses> ExpenseList = new ArrayList<>();

        //Dodawanie 10-ciu opcji w menu.
        MenuList.add(new Drinks(0, "Caffe Latte", 6.65, "Coffee", true));
        MenuList.add(new Drinks(1, "Earl Grey", 4.34, "Tea", true));
        MenuList.add(new Drinks(2, "Coca Cola", 4.50, "Soft drinks", false));
        MenuList.add(new Drinks(3, "Fanta", 5.15, "Soft drinks", false));
        MenuList.add(new Drinks(4, "Bubble Tea", 15.25, "Iced tea", false));
        MenuList.add(new meals(5, "Fries", 12.49, "Side dish", 311));
        MenuList.add(new meals(6, "Cheese Burger", 13.79, "Sandwiches", 434));
        MenuList.add(new meals(7, "Pizza with salami", 30.89, "Pizza", 2505));
        MenuList.add(new meals(8, "Tiramisu", 8.49, "Dessert", 616));
        MenuList.add(new meals(9, "Ice Cream", 6.49, "Dessert", 252));

        LocalDate today = LocalDate.now();
        DayOfWeek todayDay = DayOfWeek.from(today);


        // Trzeba stworzyc osobną klasę na promocje oraz stworzyc metode nadchodzacych promocji dla klienta
            if(todayDay.name().equals("MONDAY")) {
                int percentage = 20;
                for (Menu menu : MenuList) {
                    double price = menu.getPrice();

                    double discount = price * ((double) percentage / 100);
                    price = price - discount;
                    menu.setPrice(price);
                }
            } else if(todayDay.name().equals("THURSDAY")) {
                int percentage = 15;
                for (Menu menu : MenuList) {
                    double price = menu.getPrice();

                    double discount = price * ((double) percentage / 100);
                    price = price - discount;
                    menu.setPrice(price);
                }
            }

        Scanner scanner = new Scanner(System.in);

        String username = "admin";
        String password = "Kowalski1997";


        boolean isChoosed = false;

        while(!isChoosed) {
            System.out.println("Select 1) Admin, 2) User");
            int choice_login = scanner.nextInt();
            switch (choice_login) {
                case 1:
                    System.out.println("Enter username.");
                    String username_choice = scanner.next();
                    System.out.println("Enter password");
                    String password_choice = scanner.next();

                    if(username_choice.equals(username) && password_choice.equals(password)) {
                        //dodawanie 8 pracowników do listy Workers.
                        Workers.add(new Kitchen(0, "Adrianna", "Nowak", 31, 3182.00, "Cook", "NowakAdrianna@gmail.com", LocalDate.of(2017, 2, 20), 8));
                        Workers.add(new Kitchen(1, "Eric", "Williams", 25, 3040.00, "Cook", LocalDate.of(2020, 6, 13), 3));
                        Workers.add(new Kitchen(2, "Bartłomiej", "Zając", 41, 5698.00, "Executive chief", "BartlomiejZajac@dayrep.com", LocalDate.of(2015, 6, 13), 15));
                        Workers.add(new Kitchen(3, "Jowita", "Grabowska", 36, 4532.00, "Sous chief", "JowitaGrabowska@jourrapide.com", LocalDate.of(2016, 12, 6), 12));
                        Workers.add(new Waiters(4, "Arcangelo", "Russo", 22, 2215.00, "Server", "ArcangeloRusso@armyspy.com", LocalDate.of(2021, 4, 18), 50));
                        Workers.add(new Waiters(5, "Mattalic", "Twofoot", 24, 2542.00, "Host", "MattalicTwofoot@wp.com", LocalDate.of(2019, 1, 30), 54));
                        Workers.add(new Waiters(6, "Ayrton", "Malave", 19, 2100.00, "Trainee", LocalDate.of(2022, 5, 15), 35));
                        Workers.add(new Waiters(7, "David", "Schmitz", 47, 3417.00, "Head waiter", "DavidSchmitz@armyspy.com", LocalDate.of(2015, 4, 2), 76));

                        //Dodawanie Income
                        IncomeList.add(new Income(12000, 387, LocalDate.of(2023, 11, 15)));

                        //Dodawanie Expenses
                        ExpenseList.add(new Expenses(4000, 1200, 500, LocalDate.of(2023, 11, 30)));

                        //pierwsze menu w którym użytkownik może wybrac co chce zrobić. Program zakończy zadanie wyłącznie wtedy kiedy wpisze 4
                        int choice_menu = 0;
                        while (choice_menu != 4) {
                            for(int i = 0; i < 25; i++) {
                                System.out.println();
                            }
                            System.out.println("Restaurant Management");
                            System.out.println("Choose what you want to see.");
                            System.out.println("-------------------------------------");
                            System.out.println("1. Personnel Management");
                            System.out.println("2. Income/Expenses Management");
                            System.out.println("3. Menu Management");
                            System.out.println("4. Exit");
                            System.out.println("-------------------------------------");

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
                                    income_expensesManagement(IncomeList, ExpenseList);
                                    break;
                                case 3:
                                    System.out.println("Menu: ");
                                    for (Menu menu : MenuList) {
                                        System.out.println(menu.displayMenu());
                                    }
                                    System.out.println("-------------------------------------");
                                    System.out.println("1. Add new item to menu.");
                                    System.out.println("2. Change existing menu.");
                                    System.out.println("3. Discount food/drinks");
                                    System.out.println("4. Remove items from existing menu.");
                                    System.out.println("-------------------------------------");
                                    int choice_menuList = scanner.nextInt();
                                    switch (choice_menuList) {
                                        case 1 -> Menu.addItem(MenuList);
                                        case 2 -> changeItem(MenuList);
                                        case 3 -> Menu.setDiscountedPrice(MenuList);
                                        case 4 -> Menu.removeItem(MenuList);
                                    }
                            }
                        }
                        break;
                    }
                case 2:
                    System.out.println("Restaurant");
                    System.out.println("Choose what you want to do.");
                    System.out.println("-------------------------------------");
                    System.out.println("1. Buy food/drinks");
                    System.out.println("2. Reserve table");
                    System.out.println("3. Upcoming sales");
                    System.out.println("-------------------------------------");

                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:

                            break;
                        case 2:


                        case 3:


                    }

            }
        }
    }

    public static void income_expensesManagement(List<Income> incomeList, List<Expenses> expensesList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Income/Expenses Management");
        System.out.println("-------------------------------------");
        System.out.println("1. Show income");
        System.out.println("2. Show expenses");
        System.out.println("-------------------------------------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                incomeManagement(incomeList);
                break;
            case 2:
                expensesManagement(expensesList);
                break;
        }
    }

    public static void incomeManagement(List<Income> incomeList) {
        Scanner scanner = new Scanner(System.in);
        for (Income income : incomeList) {
            System.out.println(income.toString());
        }
        System.out.println("Write anything to go back.");
        scanner.nextLine();
    }

    public static void expensesManagement(List<Expenses> expensesList) {
        Scanner scanner = new Scanner(System.in);
        for (Expenses expenses : expensesList) {
            System.out.println(expenses.toString());
        }
        System.out.println("Write anything to go back.");
        scanner.nextLine();
    }

    public static void changeItem(List<Menu> MenuList) {
        Scanner scanner = new Scanner(System.in);

        boolean isChanged = false;

        do {
            System.out.println("Select name of item.");

            String nameOfChoice = scanner.next();

            for (Menu menu : MenuList) {
                if (menu.getMenuItem().equalsIgnoreCase(nameOfChoice)) {
                    System.out.println("What do you want to change?");
                    System.out.println("1. Name Of Product");
                    System.out.println("2. Price");
                    System.out.println("3. Type");

                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Type in new name of product: ");
                            String newName = scanner.next();// Podczas wpisywania 2 czesciowej nazwy zmienia tylko pierwsza czesc.
                            menu.setMenuItem(newName.trim());
                            isChanged = true;
                            break;
                        case 2:
                            System.out.println("Type in new price: ");
                            double newPrice = scanner.nextDouble();
                            menu.setPrice(newPrice);
                            isChanged = true;
                            break;
                        case 3:
                            System.out.println("Type in new type of product: ");
                            String newType = scanner.nextLine();
                            menu.setType(newType);
                            isChanged = true;
                            break;
                    }
                }

            }
        }
        while(isChanged != true);
    }

    public static void upcomingSales() {

    }
}
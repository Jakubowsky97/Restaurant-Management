package pl.gornik;

import pl.gornik.staff.Kitchen;
import pl.gornik.staff.Waiters;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int nextEmployeeId = 7;
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
        int choice_menu = 0;
        while (choice_menu != 4) {
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
                        case 1 -> addStaff(Workers);
                        case 2 -> fireStaff(Workers);
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
    }

    public static void addStaff(List<Staff> Workers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add all information about new employee.");

        System.out.println("First name: ");
        String first_name = scanner.next();

        System.out.println("Last name: ");
        String last_name = scanner.next();

        System.out.println("Age: ");
        int age = 0;

        while(age == 0) {
            double ageInput = scanner.nextDouble();

            if(ageInput < 0) {
                System.out.println("Invalid format for age. Age has to be on plus.");
                System.out.println("Age: ");
            } else {
                age = Integer.parseInt(String.valueOf(ageInput));
            }

        }

        System.out.println("Salary: ");
        double salary = 0;

        while(salary == 0) {
            double salaryInput = scanner.nextDouble();

            if(salaryInput < 0) {
                System.out.println("Invalid format for salary. Salary has to be on plus.");
                System.out.println("Salary: ");
            } else {
                salary = Double.parseDouble(String.valueOf(salaryInput));
            }

        }

        System.out.println("Speciality: ");
        String speciality = scanner.next();

        System.out.println("Email: ");
        String email = scanner.next();

        System.out.print("Date of employment (yyyy-MM-dd): ");
        LocalDate dateOfEmployment = null;

        while (dateOfEmployment == null) {
            String dateInput = scanner.next();

            try {
                dateOfEmployment = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                System.out.print("Date of employment (yyyy-MM-dd): ");
            }
        }

        System.out.println("1. Cook");
        System.out.println("2. Waiter");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Years of experience: ");
                int yearsOfExperience = scanner.nextInt();
                nextEmployeeId++;
                Workers.add(new Kitchen(nextEmployeeId, first_name, last_name, age, salary, speciality, email, dateOfEmployment, yearsOfExperience));
                break;
            case 2:
                System.out.println("Tips per day: ");
                int tipsperday = scanner.nextInt();
                nextEmployeeId++;
                Workers.add(new Waiters(nextEmployeeId, first_name, last_name, age, salary, speciality, email, dateOfEmployment, tipsperday));
                break;
        }
    }

    public static void fireStaff(List<Staff> Workers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which staff member do you want to fire?");
        System.out.println("Please enter the ID of the employee:");

        int choice = scanner.nextInt();

        Iterator<Staff> iterator = Workers.iterator();
        while (iterator.hasNext()) {
            Staff worker = iterator.next();
            int id_employee = worker.getId();

            if (id_employee == choice) {
                iterator.remove();
                System.out.println("Employee with ID " + choice + " has been fired.");
                break;
            }
        }
    }

    public static void incomeManagement() {

    }

    public static void expensesManagement() {

    }
}
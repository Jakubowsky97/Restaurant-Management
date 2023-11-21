package pl.gornik;

import pl.gornik.staff.Kitchen;
import pl.gornik.staff.Waiters;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Staff {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private double salary;
    private String speciality;
    private String email;
    private LocalDate dateOfEmployment;

    public Staff(int id, String first_name, String last_name, int age, double salary, String speciality, LocalDate dateOfEmployment) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.salary = salary;
        this.speciality = speciality;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Staff(int id, String first_name, String last_name, int age, double salary, String speciality, String email, LocalDate dateOfEmployment) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.salary = salary;
        this.speciality = speciality;
        this.email = email;
        this.dateOfEmployment = dateOfEmployment;
    }

    public String displayStaff() {
        return  "id= " + id +
                ", first_name= " + first_name  +
                ", last_name= " + last_name  +
                ", age= " + age +
                ", salary= " + salary +
                ", speciality= " + speciality +
                ", email= " + email  +
                ", dateOfEmployment=  " + dateOfEmployment;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    static int generateUniqueID(List<Staff> workers) {
        int id = 0;
        boolean idExists;

        do {
            idExists = false;
            for (Staff worker : workers) {
                if (worker.getId() == id) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                id++;
            }
        } while (idExists);

        return id;
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
                age = (int) ageInput;
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
                salary = salaryInput;
            }

        }

        System.out.println("Speciality: ");
        String speciality = scanner.next();

        System.out.println("Do you want to add email?");
        String choice_email = scanner.next();
        String email;

        if(choice_email.equalsIgnoreCase("yes")) {
            System.out.println("Email: ");
            email = scanner.next();
        } else {
            email = null;
        }


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
        int id = generateUniqueID(Workers);

        switch (choice) {
            case 1:
                System.out.println("Years of experience: ");
                int yearsOfExperience = scanner.nextInt();

                if(email == null) {
                    Workers.add(new Kitchen(id, first_name, last_name, age, salary, speciality, dateOfEmployment, yearsOfExperience));
                } else {
                    Workers.add(new Kitchen(id, first_name, last_name, age, salary, speciality, email, dateOfEmployment, yearsOfExperience));
                }
                break;
            case 2:
                System.out.println("Tips per day: ");
                int tipsperday = scanner.nextInt();

                if(email == null) {
                    Workers.add(new Waiters(id, first_name, last_name, age, salary, speciality, dateOfEmployment, tipsperday));
                } else {
                    Workers.add(new Waiters(id, first_name, last_name, age, salary, speciality, email, dateOfEmployment, tipsperday));
                }


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
}

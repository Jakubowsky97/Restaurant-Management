package pl.gornik;

import java.time.LocalDate;

public class Staff {
    private String first_name;
    private String last_name;
    private int age;
    private double salary;
    private String speciality;
    private String email;
    private LocalDate dateOfEmployment;

    public Staff(String first_name, String last_name, int age, double salary, String speciality, String email, LocalDate dateOfEmployment) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.salary = salary;
        this.speciality = speciality;
        this.email = email;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", speciality='" + speciality + '\'' +
                ", email='" + email + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
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
}

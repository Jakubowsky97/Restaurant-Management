package pl.gornik.staff;

import pl.gornik.Staff;

import java.time.LocalDate;

public class Waiters extends Staff {
    private int numberOfTipsPerDay;

    public Waiters(String first_name, String last_name, int age, double salary, String speciality, String email, LocalDate dateOfEmployment, int numberOfTipsPerDay) {
        super(first_name, last_name, age, salary, speciality, email, dateOfEmployment);
        this.numberOfTipsPerDay = numberOfTipsPerDay;
    }

    public int getNumberOfTipsPerDay() {
        return numberOfTipsPerDay;
    }

    public void setNumberOfTipsPerDay(int numberOfTipsPerDay) {
        this.numberOfTipsPerDay = numberOfTipsPerDay;
    }
}

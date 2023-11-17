package pl.gornik.staff;

import pl.gornik.Staff;

import java.time.LocalDate;

public class Kitchen extends Staff {
    private int yearsOfExperience;

    public Kitchen(int id, String first_name, String last_name, int age, double salary, String speciality, String email, LocalDate dateOfEmployment, int yearsOfExperience) {
        super(id, first_name, last_name, age, salary, speciality, email, dateOfEmployment);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String displayStaff() {
        return super.displayStaff() +
                ", years of experience= " + yearsOfExperience
                + "}";
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

package pl.gornik;

import java.time.LocalDate;

public class Income {
    private double MonthlyIncome;
    private double dailyIncome;
    private LocalDate dateOfTransaction;

    public Income(double monthlyIncome, double dailyIncome, LocalDate dateOfTransaction) {
        this.MonthlyIncome = monthlyIncome;
        this.dailyIncome = dailyIncome;
        this.dateOfTransaction = dateOfTransaction;
    }

    public double getMonthlyIncome() {
        return MonthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public String toString() {
        return "Income{" +
                "MonthlyIncome=" + MonthlyIncome +
                ", dailyIncome=" + dailyIncome +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }
}

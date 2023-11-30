package pl.gornik;

import java.time.LocalDate;

public class Expenses {
    private double expensesMonthly;
    private double taxes;
    private double additionalPayments;
    private LocalDate dateToSettlePayments;

    public Expenses(double expensesMonthly, double taxes, double additionalPayments, LocalDate dateToSettlePayments) {
        this.expensesMonthly = expensesMonthly;
        this.taxes = taxes;
        this.additionalPayments = additionalPayments;
        this.dateToSettlePayments = dateToSettlePayments;
    }

    public double getExpensesMonthly() {
        return expensesMonthly;
    }

    public void setExpensesMonthly(double expensesMonthly) {
        this.expensesMonthly = expensesMonthly;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getAdditionalPayments() {
        return additionalPayments;
    }

    public void setAdditionalPayments(double additionalPayments) {
        this.additionalPayments = additionalPayments;
    }

    public LocalDate getDateToSettlePayments() {
        return dateToSettlePayments;
    }

    public void setDateToSettlePayments(LocalDate dateToSettlePayments) {
        this.dateToSettlePayments = dateToSettlePayments;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "expensesMonthly=" + expensesMonthly +
                ", taxes=" + taxes +
                ", additionalPayments=" + additionalPayments +
                ", dateToSettlePayments=" + dateToSettlePayments +
                '}';
    }
}

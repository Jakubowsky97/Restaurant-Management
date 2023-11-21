package pl.gornik.food;

import pl.gornik.Menu;

public class meals extends Menu {
    private int calories;

    public meals(int id_food, String menuItem, Double price, String type, int calories) {
        super(id_food, menuItem, price, type);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String displayMenu() {
        return super.displayMenu() +
                ", calories= " + calories;
    }
}

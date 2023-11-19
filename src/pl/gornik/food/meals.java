package pl.gornik.food;

import pl.gornik.Menu;

public class meals extends Menu {
    public int calories;

    public meals(int id_food, String menuItem, Double price, String type, int calories) {
        super(id_food, menuItem, price, type);
        this.calories = calories;
    }

    @Override
    public String displayMenu() {
        return super.displayMenu() +
                ", calories= " + calories
                + "}";
    }
}

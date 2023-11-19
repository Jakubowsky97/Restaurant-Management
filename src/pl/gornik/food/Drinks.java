package pl.gornik.food;

import pl.gornik.Menu;

public class Drinks extends Menu {
    public boolean isHot;

    public Drinks(int id_food, String menuItem, Double price, String type, boolean isHot) {
        super(id_food, menuItem, price, type);
        this.isHot = isHot;
    }

    @Override
    public String displayMenu() {
        return super.displayMenu() +
                ", isHot= " + isHot
                + "}";
    }
}

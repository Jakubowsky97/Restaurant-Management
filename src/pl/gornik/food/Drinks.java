package pl.gornik.food;

import pl.gornik.Menu;

public class Drinks extends Menu {
    public boolean isHot;

    public Drinks(String menuItem, Double price, String type, boolean isHot) {
        super(menuItem, price, type);
        this.isHot = isHot;
    }

    @Override
    public String displayMenu() {
        return super.displayMenu() +
                ", isHot= " + isHot
                + "}";
    }
}

package pl.gornik.food;

import pl.gornik.Menu;

public class Drinks extends Menu {
    private boolean isHot;

    public Drinks(int id_food, String menuItem, Double price, String type, boolean isHot) {
        super(id_food, menuItem, price, type);
        this.isHot = isHot;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    @Override
    public String displayMenu() {
        return super.displayMenu() +
                ", isHot= " + isHot;
    }
}

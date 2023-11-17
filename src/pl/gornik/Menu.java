package pl.gornik;

public class Menu {
    public String menuItem;
    public Double price;
    public String type;

    public Menu(String menuItem, Double price, String type) {
        this.menuItem = menuItem;
        this.price = price;
        this.type = type;
    }

    public String displayMenu() {
        return "Menu{" +
                "menuItem= '" + menuItem +
                ", price= " + price +
                ", type= '" + type;

    }
}

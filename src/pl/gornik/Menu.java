package pl.gornik;

public class Menu {
    public int id_food;
    public String menuItem;
    public Double price;
    public String type;

    public Menu(int id_food, String menuItem, Double price, String type) {
        this.id_food = id_food;
        this.menuItem = menuItem;
        this.price = price;
        this.type = type;
    }

    public String displayMenu() {
        return "Menu{" +
                "id_food= " + id_food +
                ", menuItem= " + menuItem +
                ", price= " + price +
                ", type= " + type;

    }
}

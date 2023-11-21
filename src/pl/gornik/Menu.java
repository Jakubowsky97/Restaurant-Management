package pl.gornik;

import pl.gornik.food.meals;

import java.util.List;
import java.util.Scanner;

import static pl.gornik.Main.generateUniqueID;

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

    public int getId_food() {
        return id_food;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static int generateUniqueID(List<Menu> MenuList) {
        int id = 0;
        boolean idExists;

        do {
            idExists = false;
            for (Menu menu : MenuList) {
                if (menu.getId_food() == id) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                id++;
            }
        } while (idExists);

        return id;
    }

    public static void addItem(List<Menu> MenuList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name item: ");
        String menuItem = scanner.next();

        System.out.println("Price: ");
        Double price = scanner.nextDouble();

        System.out.println("Type of food:");
        String type = scanner.next();

        System.out.println("Meal or Drink.");
        String choice = scanner.next();

        int id = generateUniqueID(MenuList);

        if(choice.equalsIgnoreCase("meal")) {
            //MenuList.add(new meals())
        }


    }

    public static void changeItem(List<Menu> MenuList) {

    }

    public static void removeItem(List<Menu> MenuList) {

    }
}

package pl.gornik;

import pl.gornik.food.Drinks;
import pl.gornik.food.meals;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

    public Menu(Menu menu) {
        this(menu.id_food, menu.menuItem, menu.price, menu.type);
    }

    public String displayMenu() {
        return "id_food= " + id_food +
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

        boolean choice_isTrue = true;
        while(choice_isTrue) {
            System.out.println("Meal or Drink.");
            String choice = scanner.next();

            int id = generateUniqueID(MenuList);

            if (choice.equalsIgnoreCase("meal")) {
                System.out.println("How much calories: ");
                int calories = scanner.nextInt();

                MenuList.add(new meals(id, menuItem, price, type, calories));
                choice_isTrue = false;
            } else if (choice.equalsIgnoreCase("drinks")) {
                System.out.println("Is hot?");
                boolean isHot = scanner.nextBoolean();
                choice_isTrue = false;
                MenuList.add(new Drinks(id, menuItem, price, type, isHot));
            } else {
                choice_isTrue = true;
            }
        }

    }

    public static void removeItem(List<Menu> MenuList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item from menu do you want to remove?");
        System.out.println("Please enter the ID of the item:");

        int choice = scanner.nextInt();
        Iterator<Menu> iterator = MenuList.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            int id_item = menu.id_food;

            if(id_item == choice) {
                iterator.remove();
                System.out.println("Item with ID " + choice + " has been removed.");
                System.out.println();
                System.out.println("Write anything to go back.");
                scanner.nextLine();
                break;
            }

        }
    }

    public static void setDiscountedPrice(List<Menu> MenuList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select item from menu, you want to discount.");
        String choice = scanner.next();
        System.out.println("How much percentage you want discount?");
        int percentage = scanner.nextInt();
        for (Menu menu : MenuList) {
            if(choice.equalsIgnoreCase(menu.getMenuItem())) {
                double price = menu.getPrice();
                if (percentage >= 0 && percentage <= 100) {
                    double discount = price * ((double) percentage / 100);
                    price = price - discount;
                    menu.setPrice(price);
                } else {
                    System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
                }
                System.out.println("Write anything to go back.");
                scanner.nextLine();
            }
        }
    }
}

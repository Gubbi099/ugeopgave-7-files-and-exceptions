import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
    private ArrayList<Drink> coffeeMenu = new ArrayList<>();

    public void addDrink(Drink drink) {
        coffeeMenu.add(drink);
    }

    public void loadData() {
        ArrayList<Drink> drinks = new ArrayList<>();
        File path = new File("data/menu.csv");

        try {
            Scanner scan = new Scanner(path);

            scan.nextLine(); // Skip save header
            while (scan.hasNextLine()) {
                String[] splitData = scan.nextLine().split(",");
                String drinkName = splitData[0].trim();
                try {
                    int drinkPrice = Integer.parseInt(splitData[1].trim());
                    int drinkSoldNumber = Integer.parseInt(splitData[2].trim());
                    coffeeMenu.add(new Drink(drinkName, drinkPrice, drinkSoldNumber));
                } catch (NumberFormatException e) {
                    System.out.println("Cannot read data from file!");
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Café menu save file not found!");
        }
    }

    public void saveData() {
        File path = new File("data/menu.csv");

        try {
            FileWriter writer = new FileWriter(path);
            writer.write("Name, Price, Sold" + "\n"); // Create header

            for (Drink d : coffeeMenu) {
                writer.write(d.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot write to save file!");
        }
    }

    public void showMenu() {
        System.out.println("--- Coffee Menu ---");
        for (Drink d : coffeeMenu) {
            System.out.println(d.getName() + " - Price: " + d.getPrice() + " - Sales: " + d.getSoldNumber());
        }
        System.out.println();
    }

}

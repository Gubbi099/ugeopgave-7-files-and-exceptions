public class Drink {
    private String name;
    private int price;
    private int soldNumber;

    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Drink(String name, int price, int soldNumber) {
        this.name = name;
        this.price = price;
        this.soldNumber = soldNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        if (soldNumber < 0) {
            throw new IllegalArgumentException("'soldNumber' can't be negative!");
        }
        this.soldNumber = soldNumber;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.price + ", " + this.soldNumber;
    }

}

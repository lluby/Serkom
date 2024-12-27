package org.example.Models;

public class Menu {

    // Deklarasi variabel pada class menu
    private final int id;
    private final String name;
    private final int price;

    //construct
    public Menu(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getter setter method
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + ". " + name + " | Rp" + price;
    }
}

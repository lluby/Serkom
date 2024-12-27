package org.example.Models;

public class Order {
    //atribut
    private final Menu menu;
    private final int quantity;

    //constract
    public Order(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    //getter setter method
    public Menu getMenu() {
        return menu;
    }
    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menu.getName() + " x " + quantity + " = Rp" + getTotalPrice();
    }
}

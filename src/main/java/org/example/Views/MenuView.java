package org.example.Views;

import org.example.Models.Menu;
import org.example.Models.PaymentRecords;

import java.util.List;

public class MenuView {
    public void showMenu(List<Menu> menuList) {
        System.out.println("Menu:");
        menuList.forEach(System.out::println);
    }

    public void showOrderPrompt() {
        System.out.print("Enter the menu number to order: ");
    }

    public void showQuantityPrompt() {
        System.out.print("Enter the quantity: ");
    }

    public void showOrderAddedMessage(Menu menu, int quantity) {
        System.out.println("Added " + quantity + " x " + menu.getName() + " to your order.");
    }

    public void showInvalidMenuMessage() {
        System.out.println("Invalid menu choice. Please try again.");
    }

    public void showInvalidQuantityMessage() {
        System.out.println("Invalid quantity. Please try again.");
    }

    public void showRecapitulation(List<PaymentRecords> records) {
        System.out.println("=== Transaction Recapitulation ===");
        for (PaymentRecords record : records) {
            System.out.printf("ID: %d, Total: %d, Tanggal: %s%n",
                    record.getId(),
                    record.getTotalPrice(),
                    record.getPaymentDate().toString());
        }
    }

    public void showNoRecapitulationMessage() {
        System.out.println("No transactions recorded.");
    }

    public void showRecapitulationErrorMessage(Exception e) {
        System.out.println("An error occurred while loading the recapitulation: " + e.getMessage());
    }
}

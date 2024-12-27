package org.example.Controller;

import org.example.Models.*;
import org.example.Service.MenuOperations;
import org.example.Views.MenuView;
import org.example.Views.PaymentView;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController implements MenuOperations {
    //deklarasi atribut
    private final List<Menu> menuList;
    private final List<Order> orderList;
    private final MenuView menuView;

    //deklarasi construct
    public MenuController() {
        this.menuList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.menuView = new MenuView();
        initializeMenu();
    }

    //method untuk menginisialisasi menu
    private void initializeMenu() {
        menuList.add(new Menu(1, "Nasi Goreng", 15000));
        menuList.add(new Menu(2, "Mie Goreng", 13000));
        menuList.add(new Menu(3, "Nasi + Ayam Goreng", 18000));
        menuList.add(new Menu(4, "Nasi + Ayam Bakar", 19000));
        menuList.add(new Menu(5, "Nasi + Ayam Geprek", 16000));
        menuList.add(new Menu(6, "Es Teh Manis", 3000));
        menuList.add(new Menu(7, "Es Jeruk", 5000));
        menuList.add(new Menu(8, "Teh Manis Anget", 3000));
    }

    @Override
    public void displayMenu() {
        menuView.showMenu(menuList);
    }

    @Override
    public void orderMenu() {
        Scanner scanner = new Scanner(System.in);
        menuView.showOrderPrompt();
        int menuChoice = scanner.nextInt();

        if (menuChoice >= 1 && menuChoice <= menuList.size()) {
            Menu selectedMenu = menuList.get(menuChoice - 1);
            menuView.showQuantityPrompt();
            int quantity = scanner.nextInt();

            if (quantity > 0) {
                Order order = new Order(selectedMenu, quantity);
                orderList.add(order);
                menuView.showOrderAddedMessage(selectedMenu, quantity);
            } else {
                menuView.showInvalidQuantityMessage();
            }
        } else {
            menuView.showInvalidMenuMessage();
        }
    }

    @Override
    public void showRecapitulation() {
        try {
            List<PaymentRecords> records = DatabaseConnector.PaymentRecords();
            if (records.isEmpty()) {
                menuView.showNoRecapitulationMessage();
            } else {
                menuView.showRecapitulation(records);
            }
        } catch (Exception e) {
            menuView.showRecapitulationErrorMessage(e);
        }
    }

    public void processPayment() {
        int totalPrice = orderList.stream().mapToInt(Order::getTotalPrice).sum();

        PaymentView paymentView = new PaymentView();
        if (totalPrice > 0) {
            PaymentReceipt receipt = new PaymentReceipt(orderList, totalPrice);
            try {
                FileHandler.saveToFile("receipt.txt", receipt.toString());
                Date currentDate = Date.valueOf(receipt.getDate());
                DatabaseConnector.savePayment(totalPrice, currentDate);
                paymentView.showPaymentSuccessMessage(receipt);
            } catch (IOException e) {
                paymentView.showPaymentErrorMessage(e);
            }
        } else {
            paymentView.showNoOrderMessage();
        }
    }
}

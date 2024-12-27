package org.example;

import org.example.Controller.MainController;
import org.example.Models.DatabaseConnector;
import org.example.Models.Order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.startApplication();
        List<Order> orderList = new ArrayList<>();
        int totalPrice = orderList.stream().mapToInt(Order::getTotalPrice).sum();
        Date currentDate = Date.valueOf(java.time.LocalDate.now());
        DatabaseConnector.savePayment(totalPrice, currentDate);
    }
}
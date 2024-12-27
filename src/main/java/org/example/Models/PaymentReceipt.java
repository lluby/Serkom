package org.example.Models;

import lombok.Getter;

import java.util.List;

public class PaymentReceipt {
    //atribut
    private final List<Order> orders;
    private final int totalPrice;
    @Getter
    private final String date;

    //construct
    public PaymentReceipt(List<Order> orders, int totalPrice) {
        this.orders = orders;
        this.totalPrice = totalPrice;
        this.date = java.time.LocalDate.now().toString();
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n======= Receipt =======\n");
        for (Order order : orders) {
            receipt.append(order).append("\n");
        }
        receipt.append("-----------------------\n");
        receipt.append("Total: Rp").append(totalPrice).append("\n");
        receipt.append("Date: ").append(date).append("\n");
        return receipt.toString();
    }
}

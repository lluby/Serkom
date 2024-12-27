package org.example.Views;

import org.example.Models.PaymentReceipt;

public class PaymentView {
    public void showPaymentSuccessMessage(PaymentReceipt receipt) {
        System.out.println("Payment successful! Here is your receipt:");
        System.out.println(receipt);
    }

    public void showPaymentErrorMessage(Exception e) {
        System.out.println("Error processing payment: " + e.getMessage());
    }

    public void showNoOrderMessage() {
        System.out.println("No orders to process payment for.");
    }
}

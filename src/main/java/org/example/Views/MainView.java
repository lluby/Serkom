package org.example.Views;

public class MainView {
    public void showWelcomeMessage() {
        System.out.println("=============================");
        System.out.println("Welcome to OrderYuk!");
        System.out.println("=============================");
    }

    public void showMainMenu() {
        System.out.println();
        System.out.println("1. Order Menu");
        System.out.println("2. Process Payment");
        System.out.println("3. Recapitulation");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void showExitMessage() {
        System.out.println("Thank you for using OrderYuk!. Goodbye!");
    }

    public void showInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }
}

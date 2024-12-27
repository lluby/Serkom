package org.example.Controller;

import org.example.Service.MenuOperations;
import org.example.Views.MainView;

import java.util.Scanner;

public class MainController extends BaseController {
    //deklarasi atribut
    private final MainView mainView;
    private final MenuController menuController;

    //deklarasi construct
    public MainController() {
        this.mainView = new MainView();
        this.menuController = new MenuController();
    }
    @Override
    public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            mainView.showWelcomeMessage();
            menuController.displayMenu();
            mainView.showMainMenu();
            choice = scanner.nextInt();
            if (choice == 1) {
                menuController.orderMenu();
            } else if (choice == 2) {
                menuController.processPayment();
            } else if (choice == 3) {
                menuController.showRecapitulation();
            } else if (choice == 0) {
                mainView.showExitMessage();
            } else {
                mainView.showInvalidChoiceMessage();
            }
        } while (choice != 0);
        scanner.close();
    }
}

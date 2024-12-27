package org.example.Service;

import org.springframework.stereotype.Service;

@Service
public interface MenuOperations {
    //method utama
    void displayMenu();
    void orderMenu();
    void showRecapitulation();
}

package org.example;

import org.example.contoller.MenuController;
import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.service.PrinterMonitor;
import org.example.view.ConsoleIO;

/**
 * App class for the 3D Printer Manager Application
 *
 */
public class App {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.run();
    }
}

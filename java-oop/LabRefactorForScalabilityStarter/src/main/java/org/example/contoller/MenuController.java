package org.example.contoller;

import org.example.exception.PrinterKeyExistsException;
import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.view.ConsoleIO;

public class MenuController {

    ConsoleIO io;
    PrinterManager printerManager;


    public void run() {
        io = ConsoleIO.getInstance();

        printerManager = new PrinterManager();

        boolean running = true;

        io.displayMessage("Printer monitor online");

        while (running) {
            io.displayMessage("[D]isplay printer status");
            io.displayMessage("[P]rint an object");
            io.displayMessage("[C]lear the print bed");
            io.displayMessage("[A]dd Printer");
            io.displayMessage("e[X]it");
            String choice = io.getStringRequired("");

            switch (choice) {
                case "D":
                    display();
                    break;
                case "P":
                    print();
                    break;
                case "C":
                    clear();
                    break;
                case "A":
                    add();
                    break;
                case "X":
                    running = false;
                    break;
            }
        }
        io.displayMessage("Halting printer monitors");
        printerManager.haltMonitors();
        io.displayMessage("Goodbye!");
        System.exit(0);
    }

    private void display() {
        for (String printerId : printerManager.getAllPrinterIds()) {
            io.displayMessage(printerManager.getPrinter(printerId).toString());
        }
    }

    private void add() {
        String printerId = io.getStringRequired("Enter Printer ID");
        String printerName = io.getStringRequired("Enter Printer Name");
        try {
            printerManager.addPrinter(printerId, new Printer(printerId, printerName));
        } catch (PrinterKeyExistsException e) {
            io.displayMessage("Printer with that key already exists.");
        }
    }

    private void print() {
        Printer printer = getPrinterById();
        if (printer == null) {
            return;
        }
        if (printer.getStatus().equals(Printer.PrinterStatus.READY)) {
            String file = io.getStringRequired("Object to print");
            printer.print(file);
        } else {
            io.displayMessage("Printer not ready to accept a new print.");
        }
    }

    private void clear() {
        Printer printer = getPrinterById();
        if (printer == null) {
            return;
        }
        if (printer.getStatus().equals(Printer.PrinterStatus.COMPLETE)) {
            io.displayMessage("Retrieving " + printer.getPrintModelName());
            printer.clearBed();
            io.displayMessage(printer.toString());
        } else {
            io.displayMessage("Print incomplete or not started.");
        }
    }

    private Printer getPrinterById() {
        Printer printer = printerManager.getPrinter(io.getStringRequired("Enter Printer ID"));
        if (printer == null) {
            io.displayMessage("Printer not found.");
        }
        return printer;
    }
}

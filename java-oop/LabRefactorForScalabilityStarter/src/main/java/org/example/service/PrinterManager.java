package org.example.service;

import org.example.exception.PrinterKeyExistsException;
import org.example.model.Printer;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrinterManager {
    private Map<String, Printer> printerIds;
    private List<PrinterMonitor> printerMonitors;

    public PrinterManager() {
        printerIds = new HashMap<>();
        printerMonitors = new ArrayList<>();
    }

    public void addPrinter(String key, Printer printer) {
        if (printerIds.containsKey(key)) {
            throw new PrinterKeyExistsException();
        }
        printerIds.put(key, printer);
        printerMonitors.add(new PrinterMonitor(printer));
    }

    public Printer getPrinter(String key) {
        return printerIds.get(key);
    }

    public List<String> getAllPrinterIds() {
        return printerIds.keySet().stream().toList();
    }

    public void haltMonitors() {
        for (PrinterMonitor monitor : printerMonitors) {
            monitor.cancel();
        }
    }
}

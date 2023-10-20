package model;

import utils.RenderTable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StockManagement {
    List<Stock> stocks;
    private int currentPage;
    private int rowsPerPage;

    public StockManagement() {
        stocks = new ArrayList<>();
        currentPage = 1;
        rowsPerPage = 5; // Default value
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    public void displayStocks() {
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, stocks.size());

        System.out.println("--- Stocks ---");
        RenderTable.renderStock(stocks.subList(startIndex, endIndex));

        System.out.println("Page " + currentPage + " of " + getTotalPages());
    }

    public void searchProduct(String name) {
        List<Stock> searchResults = new ArrayList<>();

        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                searchResults.add(stock);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No products found with the given name.");
        } else {
            for (Stock stock : searchResults) {
                displayStocks();
            }
        }
    }


    public void updateStock(String name, int newQuantity, double newPrice) {
        for (Stock stock : stocks) {
            if (stock.getName().equals(name)) {
                stock.setQuantity(newQuantity);
                stock.setPrice(newPrice);
                System.out.println("Stock updated successfully.");
                return;
            }
        }

        System.out.println("Stock not found.");
    }

    public void deleteStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equals(name)) {
                stocks.remove(stock);
                System.out.println("Stock deleted successfully.");
                return;
            }
        }

        System.out.println("Stock not found.");
    }

    public void goToFirstPage() {

        currentPage = 1;
        displayStocks();
    }

    public void goToLastPage() {

        currentPage = getTotalPages();
        displayStocks();
    }

    public void goToNextPage() {
        if (currentPage < getTotalPages()) {
            currentPage++;
            displayStocks();
        }else {
            currentPage = 1;
            displayStocks();
        }
    }

    public void goToPreviousPage() {
        if (currentPage > 1) {
            currentPage--;
            displayStocks();
        }else {
            currentPage = getTotalPages();
            displayStocks();
        }
    }
    public void goToPage(int page) {
        if (page < 1 || page > getTotalPages()) {
            System.out.println("Invalid page number.");
        } else {
            currentPage = page;
            displayStocks();
        }
    }

    public void saveRecord() {
        System.out.print("Do you want to save this record? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            try {
                FileWriter writer = new FileWriter("data.txt");
                // Write the data to the file
                for (Stock stock : stocks) {
                    writer.write(stock.toString() + "\n");
                }
                writer.close();
                System.out.println("Record saved successfully.");
            } catch (IOException e) {
                System.out.println("Failed to save the record.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Record not saved.");
        }
    }


    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) stocks.size() / rowsPerPage);
    }
}

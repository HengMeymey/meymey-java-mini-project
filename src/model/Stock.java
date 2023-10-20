package model;

import java.util.Date;

public class Stock {
    private static int nextId = 1;
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Date importedDate;

    public Stock(String name, int quantity, double price) {
        this.id = nextId++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.importedDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImportedDate() {
        return importedDate;
    }
}

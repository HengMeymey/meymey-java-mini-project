import model.StockManagement;
import utils.RenderMessage;
import utils.RenderTable;
import model.Stock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockManagement stockManagement = new StockManagement();

        boolean exit = false;
        List<String> welcomeMenu = new ArrayList<>(List.of("Add Stock","Display Stocks","Search Product","Update Stock","Delete Stock","Go to First Page","Go to Last Page","Go to Next Page","Go to Previous Page","Go to page","Set Rows per Page","Save Record","Exit"));
        RenderMessage.welcomeMessage();
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+= STOCK MANAGEMENT +=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        while (!exit) {
            RenderTable.renderMenu(welcomeMenu);
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    Stock stock = new Stock(name, quantity, price);
                    stockManagement.addStock(stock);
                    break;
                case 2:
                    stockManagement.displayStocks();
                    break;
                case 3:
                    System.out.print("Enter product name to search: ");
                    scanner.nextLine();
                    String searchName = scanner.nextLine();
                    stockManagement.searchProduct(searchName);
                    break;
                case 4:
                    System.out.print("Enter product name to update: ");
                    scanner.nextLine();
                    String nameToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    stockManagement.updateStock(nameToUpdate, newQuantity, newPrice);
                    break;
                case 5:
                    System.out.print("Enter product name to delete: ");
                    scanner.nextLine();
                    String nameToDelete = scanner.nextLine();
                    stockManagement.deleteStock(nameToDelete);
                    break;
                case 6:
                    stockManagement.goToFirstPage();
                    break;
                case 7:
                    stockManagement.goToLastPage();
                    break;
                case 8:
                    stockManagement.goToNextPage();
                    break;
                case 9:
                    stockManagement.goToPreviousPage();
                    break;
                case 10:
                    System.out.println("Enter the page you want to view : ");
                    int toPage = scanner.nextInt();
                    stockManagement.goToPage(toPage);
                    break;
                case 11:
                    System.out.print("Enter rows per page: ");
                    int rowsPerPage = scanner.nextInt();
                    stockManagement.setRowsPerPage(rowsPerPage);
                    stockManagement.displayStocks();
                    break;
                case 12:
                    stockManagement.saveRecord();
                    break;
                case 13:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            RenderTable.pressEnterKey();
        }

        System.out.println("Exiting Stock Management System.");
        scanner.close();
    }
}

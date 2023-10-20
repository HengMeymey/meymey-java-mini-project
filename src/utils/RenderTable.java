package utils;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import model.Stock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RenderTable {
    public static void renderMenu(List<String> menu){

        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        table.setColumnWidth(0,5,6);
        table.setColumnWidth(1,25,45);
        table.addCell("No",cellStyle);
        table.addCell("Operation",cellStyle);
        for (int i = 0 ;i<menu.size();i++){
            table.addCell((i+1)+"",cellStyle);
            table.addCell(menu.get(i));
        }
        System.out.println(table.render());
    }
    public static void renderStock(List<Stock> stockList){
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        //render menu
        List<String> studentMenu = new ArrayList<>(List.of(""+"ID","Name","Quantity","Price","Imported Date"));
        table.setColumnWidth(1,25,30);
        table.setColumnWidth(2,15,25);
        table.setColumnWidth(3,20,30);
        table.setColumnWidth(4,30,40);

        for (String menu : studentMenu){
            table.addCell(menu);
        }

        for(Stock stock: stockList){
            table.addCell(stock.getId()+"");
            table.addCell(stock.getName());
            table.addCell(stock.getQuantity()+"");
            table.addCell(stock.getPrice()+"");
            table.addCell(stock.getImportedDate()+"");
        }
        table.addCell("Total Product = "+stockList.size()+" products",cellStyle,5);
        System.out.println(table.render());
    }
    public static void pressEnterKey(){
        Scanner input = new Scanner(System.in);
        System.out.println("====================== Press Enter to Continue =====================");
        input.nextLine();
    }
}

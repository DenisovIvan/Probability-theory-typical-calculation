package teorvero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class forexcel {

    public static void createExcel(XSSFWorkbook book,String task, int r) throws FileNotFoundException, IOException {
        Sheet sheet = book.createSheet(task);
        for (int i = 0; i < r; i++) {
            Row row = sheet.createRow(i);
        }
    }

    public static void writeIntoExcel(XSSFWorkbook book,String task, int r, int n, double info) throws FileNotFoundException, IOException {
        Sheet sheet = book.getSheet(task);
        Row row = sheet.getRow(r);
        Cell cell = row.createCell(n);
        cell.setCellValue(info);
    }

    public static void writeIntoExcelString(XSSFWorkbook book,String task, int r, int n, String Str) throws FileNotFoundException, IOException {
        Sheet sheet = book.getSheet(task);
        Row row = sheet.getRow(r);
        Cell cell = row.createCell(n);
        cell.setCellValue(Str);
    }

    public static void write(XSSFWorkbook book,String task, int r, int n, double info) throws FileNotFoundException, IOException {
        Sheet sheet = book.getSheet(task);
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(n);
        String s = null;
        s = cell.getStringCellValue();
        cell.setCellValue(s+info);
    }

    public static void writeString(XSSFWorkbook book,String task, int r, int n, String str) throws FileNotFoundException, IOException {
        Sheet sheet = book.getSheet(task);
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(n);
        String s = null;
        s = cell.getStringCellValue();
        cell.setCellValue(s+str);
    }
}

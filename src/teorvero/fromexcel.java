
package teorvero;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fromexcel {
    public static double[] readFromExcelVarX(String file) throws IOException {
        double[] massx = new double[100];
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Var");
        int kol = 0;
        for (int i = 0; i < 7; i=i+2) {
        for (Row r : myExcelSheet) {
            Cell c = r.getCell(i);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    massx[kol] = c.getNumericCellValue();
                    kol=kol+1;
                } else if (c.getCellType() == Cell.CELL_TYPE_FORMULA && c.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                    massx[kol]= c.getNumericCellValue();
                    kol=kol+1;                  
                }
            }
        }}

        myExcelBook.close();
        return massx;

    }
        public static double[] readFromExcelVarY(String file) throws IOException {
        double[] massy = new double[100];
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheet("Var");
        int kol = 0;
        for (int i = 1; i < 8; i=i+2) {
        for (Row r : myExcelSheet) {
            Cell c = r.getCell(i);
            if (c != null) {
                if (c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    massy[kol] = c.getNumericCellValue();
                    kol=kol+1;
                } else if (c.getCellType() == Cell.CELL_TYPE_FORMULA && c.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
                    massy[kol]= c.getNumericCellValue();
                    kol=kol+1;                  
                }
            }
        }}

        myExcelBook.close();
        return massy;

    }
        public static double read(XSSFWorkbook book,String task,int r,int k){
            XSSFSheet sheet = book.getSheet(task);
            Row row = sheet.getRow(r);
            Cell cell = row.getCell(k);
            return cell.getNumericCellValue();
}
}

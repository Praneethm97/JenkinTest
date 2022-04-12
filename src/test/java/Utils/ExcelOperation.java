package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
    public static  ArrayList<String> getData(String sheetName, String cellName, String testcaseName) throws Exception {
        ArrayList<String> a = new ArrayList<>();
        FileInputStream fis = new FileInputStream("src//main//java//Resource//nop commerce test data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int count = workbook.getNumberOfSheets();
        for (int i = 1; i <= count; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> row = sheet.iterator();
                Row r = row.next();
                Iterator<Cell> c = r.cellIterator();
                int Column = 0;
                stop:
                while (c.hasNext()) {
                    Cell c1 = c.next();
                    if (c1.getStringCellValue().equalsIgnoreCase(cellName)) {
                        break stop;
                    }
                    Column++;
                }
                System.out.println(Column);
                while (row.hasNext()) {
                    Row desiredRow = row.next();
                    if (desiredRow.getCell(Column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
                        Iterator<Cell> cellIterator = desiredRow.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            if (cell.getCellType() == CellType.STRING) {
                                a.add(cell.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                            }
                        }
                    }
                }

            }
        }
        return a;
    }
}

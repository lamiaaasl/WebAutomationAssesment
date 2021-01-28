
package TestData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

/**
 * 
 * @param path
 * @param sheetName
 * @param testCaseName
 * @return
 * @throws InvalidFormatException
 * @throws IOException
 * 
 * get testdata for the testcase 
 */
	@SuppressWarnings("deprecation")
    public static Object[][] fetchData(String path, String testCaseName) throws InvalidFormatException, IOException {

           Row row = null;
           int cellCount = 0;
           Object data[][] = null;
           // Open the Excel file

           String FilePath = System.getProperty("user.dir")+ File.separator + path;
           FileInputStream ExcelFile = new FileInputStream(FilePath);

           // Access the required test data sheet

           ExcelWBook = new XSSFWorkbook(ExcelFile);

           ExcelWSheet = ExcelWBook.getSheet("TestCases");

           int rowcount = ExcelWSheet.getLastRowNum();
           ArrayList<Integer> tcRowsList = new ArrayList<Integer>();

           for (int i = 1; i <= rowcount; i++) {

                 row = ExcelWSheet.getRow(i);

                 if (rowIsEmpty(row))
                        break;

                 if (row.getCell(0).getStringCellValue().equals(testCaseName)) {
                        // header row
                        if (row.getCell(1) == null)

                              continue;

                        // Run mode is false

                        if (!(row.getCell(1).getBooleanCellValue()))
                        //if (row.getCell(1).getStringCellValue()=="FALSE")
                              continue;
                        cellCount = row.getLastCellNum();
                        tcRowsList.add(i);
                 }

           }
           if (tcRowsList.size() > 0) {
                 data = new Object[tcRowsList.size()][cellCount - 2];
                 for (int i = 0; i < tcRowsList.size(); i++) {

                        Row r = ExcelWSheet.getRow(tcRowsList.get(i));

                        for (int j = 2; j < cellCount; j++) {
                              Cell c = r.getCell(j);
                              try {

                                     if (c.getCellTypeEnum() == CellType.STRING) {
                                           data[i][j - 2] = c.getStringCellValue();
                                     } else if (c.getCellTypeEnum() == CellType.NUMERIC) {

                                           if (HSSFDateUtil.isCellDateFormatted(c)) {

                                                  data[i][j - 2] = c.getDateCellValue();
                                           } else {
                                                  Integer value = new Integer((int) c.getNumericCellValue());
                                                  data[i][j - 2] = value;
                                           }
                                     } else if (c.getCellTypeEnum() == CellType.BOOLEAN) {
                                           data[i][j - 2] = c.getBooleanCellValue();
                                     }

                              } catch (Exception e) {
                                     System.out.println("reading test data excel sheet failed");

                              }
                        }
                 }
           }

           return data;

    }

    @SuppressWarnings("deprecation")
    private static boolean rowIsEmpty(Row row) {
           if (row == null) {
                 return true;
           }

           for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
                 Cell cell = row.getCell(cellNum);
                 if (cell != null && cell.getCellTypeEnum() != CellType.BLANK && StringUtils.isNotBlank(cell.toString())) {
                        return false;
                 }
           }
           return true;
    }
}
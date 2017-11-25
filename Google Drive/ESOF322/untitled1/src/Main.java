import edu.princeton.cs.algs4.RedBlackBST;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        try {
            Workbook wb = WorkbookFactory.create(new File("/Users/Timothy.Osen/Downloads/11-20-2017.xls"));
            Sheet mySheet = wb.getSheetAt(0);
            ArrayList columns = new ArrayList();
            Iterator<Row> rowIterator = mySheet.rowIterator();
            System.out.println(mySheet.getRow(1).getCell(0));
            int i = 0;
            int j = 0;
            columns.add(i);
            while (rowIterator.hasNext())
            {
                i = 0;

                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell tempcell = cellIterator.next();
                if (tempcell.getStringCellValue().equals("Tim Osen") | tempcell.getStringCellValue().equals("406-570-3846"))
                {
                    while (cellIterator.hasNext())
                    {
                        i = i+1;
                        columns.add(i);
                        Cell cell = cellIterator.next();
                        System.out.print(columns.get(i));

                        //Check the cell type and format accordingly
                        if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
                            break;
                        }
                        if (cell.getStringCellValue().equals(""))
                        {
                           System.out.print("          ");
                        }
                        switch (cell.getCellType())
                        {
                            case Cell.CELL_TYPE_NUMERIC:
                                schedule.setDate(i+1,j,String.valueOf(cell.getNumericCellValue()));
                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                schedule.setDate(i+1,j,cell.getStringCellValue());
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                        }
                    }
                    System.out.println("");
                    j = j+1;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        schedule.printSchedule();

    }
}

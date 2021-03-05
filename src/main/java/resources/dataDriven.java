package resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.DateFormatConverter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class dataDriven {
    public ArrayList<String> getData(String TestcaseName) throws IOException {
        ArrayList<String> a=new ArrayList<String>();
        String CurrentDir=System.getProperty("user.dir");
        FileInputStream fis=new FileInputStream(CurrentDir+"\\src\\main\\java\\resources\\details.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        int sheets=workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("MMT")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows =sheet.iterator();
                Row FirstRow=rows.next();
                Iterator<Cell> cells=FirstRow.cellIterator();
                int k=0;
                int colomn = 0;
                while (cells.hasNext()){
                    Cell value=cells.next();
                    if(value.getStringCellValue().equals("TestCases")){
                        colomn=k;
                    }
                    k++;
                }
                while(rows.hasNext()){
                    Row r=rows.next();
                    if(r.getCell(colomn).getStringCellValue().equals(TestcaseName)){
                        Iterator<Cell> cell=r.cellIterator();
                        while (cell.hasNext()){
                            Cell c=cell.next();
                            if(c.getCellType()== CellType.STRING)
                            a.add(c.getStringCellValue());

                            else if(c.getCellType()==CellType.FORMULA){

                              LocalDate givenDate=LocalDate.parse(c.getStringCellValue());
                              a.add(givenDate.toString());

                            }
                            else
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                        }
                    }

                }
            }
        }
        return a;
    }
    public static void main(String[] Args) throws IOException {

    }
}

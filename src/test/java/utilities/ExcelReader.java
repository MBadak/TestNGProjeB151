package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    //Excel kullanabilmek icin ilk once pom dosyamiza poi yüklememiz lazim
    // https://mvnrepository.com/artifact/org.apache.poi/poi  ve
    // https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml  den alip yuklemek lazim

    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaIsmi){
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook= WorkbookFactory.create(fis);
            sheet= workbook.getSheet(sayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Satir ve sütun sayılarını girdiğimizde, O hücredeki veriyi return eden method
    public String getCellData(int satir,int sutun){
        Cell cell = sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }

    //Exceldeki satir sayısını return eden method
    public int rowCount(){
        return sheet.getLastRowNum();
    }




}
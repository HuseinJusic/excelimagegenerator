package at.jusic.modules.excelImageGenerator.handler;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class XlsxHandler {

    private XSSFWorkbook wb;
    private Sheet sheet;

    public XlsxHandler(){
        wb = new XSSFWorkbook();
        sheet = wb.createSheet();
    }

    public void generateImageFile(ArrayList<ArrayList<int[]>> list) throws IOException {
        String file = "test.xlsx";
        FileOutputStream out = new FileOutputStream(file);

        //sheet preparation
        sheet.setDisplayGridlines(false);
        sheet.setPrintGridlines(false);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        sheet.setColumnWidth(0, 10);

        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        XSSFCellStyle style = wb.createCellStyle();
        IndexedColorMap colorMap = wb.getStylesSource().getIndexedColors();

        for(int x = 0; x < list.size(); x++){
            sheet.createRow(x);
            sheet.getRow(x).setHeightInPoints(50);
            System.out.println("row created " + x );
            for(int y = 0; y < list.get(x).size(); y++){
                Cell cell = sheet.getRow(x).createCell(y);
                style.setFillForegroundColor(new XSSFColor(new Color(list.get(x).get(y)[0],list.get(x).get(y)[1],list.get(x).get(y)[2]),colorMap));
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(style);
            }
        }

        wb.write(out);
        out.close();
        wb.close();

    }

    public void xlsxTest() throws IOException {

        Color c = new Color(0x887A32);


        System.out.println(c.getRed() + " " + c.getGreen() + " " + c.getBlue());


        //turn off gridlines
        sheet.setDisplayGridlines(false);
        sheet.setPrintGridlines(false);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.createRow(1);
        Cell cell = sheet.getRow(1).createCell(1);

        XSSFCellStyle style = wb.createCellStyle();
        IndexedColorMap colorMap = wb.getStylesSource().getIndexedColors();
        XSSFColor myColor = new XSSFColor(c,colorMap);
        style.setFillForegroundColor(myColor);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        cell.setCellStyle(style);
        cell.setCellValue("Test");



        String file = "test.xlsx";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();

        wb.close();
    }


}

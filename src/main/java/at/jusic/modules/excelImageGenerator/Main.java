package at.jusic.modules.excelImageGenerator;

import at.jusic.modules.excelImageGenerator.handler.XlsxHandler;
import at.jusic.modules.excelImageGenerator.parser.ImageParser;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        ImageParser imgParser = new ImageParser("hj.jpg");
        XlsxHandler xlsxHandler = new XlsxHandler();

        xlsxHandler.generateImageFile(imgParser.getColorList());


        //System.out.println(liste.get(90).get(90)[0] + " " + liste.get(90).get(90)[1] + " " + liste.get(90).get(90)[2]);
    }

}

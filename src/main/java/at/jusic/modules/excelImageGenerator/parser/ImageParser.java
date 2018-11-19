package at.jusic.modules.excelImageGenerator.parser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * The ImageParser class is handling the images. It is able to extract the RGB values of each Pixel
 *
 *
 */
public class ImageParser {

    private BufferedImage image = null;

    public ImageParser(String img) throws IOException {
        image = ImageIO.read(new File(img));
    }

    public ArrayList<ArrayList<int[]>> getColorList(){

        ArrayList<ArrayList<int[]>> colorList = new ArrayList<ArrayList<int[]>>();

        for(int x = 0; x < image.getHeight(); x++){
            colorList.add(new ArrayList<int[]>());
            for(int y = 0; y < image.getWidth(); y++){
                Color color = new Color(image.getRGB(y, x));
                int[] arr = {color.getRed(), color.getGreen(),color.getBlue()};
                colorList.get(x).add(arr);
            }
        }

        return colorList;
    }
}

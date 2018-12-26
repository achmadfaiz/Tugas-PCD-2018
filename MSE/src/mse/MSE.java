/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mse;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Kazanan
 */
public class MSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        BufferedImage img1 = null, img2 = null;
        File f1, f2 = null;
    
        //read image
        try{
          f1 = new File("D:\\INFORMATICS ENGINEERING\\SEMESTER 7\\PCD (Tahsin)\\tugas besar image processing\\fruits.png");
          img1 = ImageIO.read(f1);
          f2 = new File("D:\\INFORMATICS ENGINEERING\\SEMESTER 7\\PCD (Tahsin)\\tugas besar image processing\\grayscale.png");
          img2 = ImageIO.read(f2);
        }catch(IOException e){
          System.out.println(e);
        }
        
        //fungsi PSNR
        printMSE(img1, img2);
    
    }  
    
    public static double printMSE(BufferedImage im1, BufferedImage im2) {
		assert(
			im1.getType() == im2.getType()
				&& im1.getHeight() == im2.getHeight()
				&& im1.getWidth() == im2.getWidth());

		double mse = 0;
		int width = im1.getWidth();
		int height = im1.getHeight();
		Raster r1 = im1.getRaster();
		Raster r2 = im2.getRaster();
		for (int j = 0; j < height; j++)
			for (int i = 0; i < width; i++)
				mse
					+= Math.pow(r1.getSample(i, j, 0) - r2.getSample(i, j, 0), 2);
		mse /= (double) (width * height);
		System.err.println("MSE = " + mse);
		return mse;
	}
    
}

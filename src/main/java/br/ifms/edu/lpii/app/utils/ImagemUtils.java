/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.edu.lpii.app.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Gustavo
 */
public class ImagemUtils {
    public static BufferedImage loadImage(String file) throws IOException {
        String path = new File(".").getAbsolutePath().replace(".", file);
        return ImageIO.read(new File(path));
    }
}

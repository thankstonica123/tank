package com.thankstonica.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by thankstonica on 2020/9/16.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(Test.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

        System.out.println(ResourceMgr.tankD);
    }
}

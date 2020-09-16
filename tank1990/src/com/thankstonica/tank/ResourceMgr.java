package com.thankstonica.tank;

import com.sun.org.apache.regexp.internal.RE;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by thankstonica on 2020/9/16.
 */
public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR,tankD;
    static {
        try {
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

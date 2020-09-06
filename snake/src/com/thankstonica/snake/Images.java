package com.thankstonica.snake;

import javax.swing.*;
import java.net.URL;

/**
 * Created by thankstonica on 2020/9/6.
 * 封装图片对象
 */
public class Images {
    //将图片路径封装成对象
    public static URL headURL = Images.class.getResource("/images/head.png");
    // 将图片封装成对象
    public static ImageIcon headImg = new ImageIcon(headURL);

    //将图片路径封装成对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    // 将图片封装成对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);

    //将图片路径封装成对象
    public static URL upURL = Images.class.getResource("/images/up.png");
    // 将图片封装成对象
    public static ImageIcon upImg = new ImageIcon(upURL);

    //将图片路径封装成对象
    public static URL rightURL = Images.class.getResource("/images/right.png");
    // 将图片封装成对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);

    //将图片路径封装成对象
    public static URL downURL = Images.class.getResource("/images/down.png");
    // 将图片封装成对象
    public static ImageIcon downImg = new ImageIcon(downURL);

    //将图片路径封装成对象
    public static URL leftURL = Images.class.getResource("/images/left.png");
    // 将图片封装成对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);
}

















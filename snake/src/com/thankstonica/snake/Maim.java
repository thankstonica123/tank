package com.thankstonica.snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by thankstonica on 2020/9/6.
 */
public class Maim {
    public static void main(String[] args) {
        // 创建窗体
        JFrame jf = new JFrame();
        //设置标题
        jf.setTitle("snake game!");
        //设置窗体位置
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);

        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //将面板放入窗体
        jf.add(new MainPanel());
        jf.setVisible(true);
    }
}

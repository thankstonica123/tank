package com.thankstonica.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by thankstonica on 2020/9/6.
 */
public class MainPanel extends JPanel {
    //小蛇的长度
    int length;

    //存储小蛇x,y轴坐标
    int[] snakeX = new int[600];
    int[] snakeY = new int[600];

    //小蛇方向
    String direction;

    //游戏启停
    boolean isStart = false;

    //初始化信息
    public void init(){
        length = 3;
        //初始化蛇头及身子
        snakeX[0] = 150;
        snakeY[0] = 275;
        //身子1
        snakeX[1] = 125;
        snakeY[1] = 275;
        //身子2
        snakeX[2] = 100;
        snakeY[2] = 275;
        direction = "R";
    }

    public MainPanel(){
        init();
        //将系统较多设置到面板上
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == 32){
                    isStart = !isStart;
                    repaint();
                }
                System.out.println(keyCode);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(200,255, 247));
        Images.headImg.paintIcon(this,g,8,10);

        g.setColor(new Color(171, 198, 255));
        g.fillRect(8,125,778,635);

        //画蛇头
        Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        switch (direction){
            case "R":Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "D":Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "L":Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);break;
            case "U":Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);break;
        }
        //画身子1
        //Images.bodyImg.paintIcon(this,g,snakeX[1],snakeY[1]);
        //画身子2
        //Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);
        //循环画身子
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        if(!isStart){
            g.setColor(new Color(255, 31, 46));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始",250,250);
        }
    }
}

package com.thankstonica.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    //食物
    int eggX;
    int eggY;

    //小蛇方向
    String direction;

    //游戏启停
    boolean isStart = false;

    //定时器
    Timer timer;

    //计分器
    int score;

    //小蛇死亡状态
    boolean isDead;

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

        eggX = 325;
        eggY = 325;

        score = 0;

        isDead = false;

    }

    public MainPanel(){
        init();
        //将系统较多设置到面板上
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_SPACE){
                    if(isDead){
                        init();
                    }else{
                        isStart = !isStart;
                        repaint();
                    }

                }
                System.out.println(keyCode);
                if(keyCode == KeyEvent.VK_UP) direction = "U";
                if(keyCode == KeyEvent.VK_DOWN) direction = "D";
                if(keyCode == KeyEvent.VK_LEFT) direction = "L";
                if(keyCode == KeyEvent.VK_RIGHT) direction = "R";

            }
        });
        //初始化定时器
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //每100毫秒执行一次
                if(isStart && !isDead){//游戏是开始，则每100毫秒执行一次
                    //蛇开始动，先动身子，再动头
                    for (int i = length - 1;i>0; i--) {
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }

                    switch (direction){
                        case "R":snakeX[0] = snakeX[0]+25;break;
                        case "D":snakeY[0] = snakeY[0]+25;break;
                        case "L":snakeX[0] = snakeX[0]-25;break;
                        case "U":snakeY[0] = snakeY[0]-25;break;
                    }

                    for (int i = 1; i < length; i++) {
                        if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                            isDead = true;
                        }
                    }

                    //设置边界
                    if(snakeX[0] > 750)snakeX[0]=25;
                    if(snakeX[0] < 25)snakeX[0]=750;
                    if(snakeY[0] < 125)snakeY[0]=725;
                    if(snakeY[0] > 725)snakeY[0]=125;

                    if(eggX == snakeX[0] && eggY == snakeY[0]){
                        length++;
                        eggX = ((int) (Math.random() * 30)+1)*25;//[1-30]
                        eggY = ((int) (Math.random() * 25)+5)*25;//[5-29]/[1-25]
                        score += 10;
                    }

                    //刷新
                    repaint();


                }
            }
        });
        timer.start();
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
        Images.foodImg.paintIcon(this,g,eggX,eggY);

        if(!isStart && !isDead){
            g.setColor(new Color(255, 31, 46));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始",250,250);
        }

        g.setColor(new Color(255, 31, 46));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("分数："+score,600,60);

        if(isDead){
            g.setColor(new Color(22, 25, 255));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("小蛇死亡，点击空格重新开始",150,250);
        }
    }
}

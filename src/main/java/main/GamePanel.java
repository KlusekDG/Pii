package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int orginaTileSize =16;
    final int scale =3;
    public final int tileSize =orginaTileSize * scale ;
    final  int maxScreenCol =16;
    final int maxScreenRow = 12;
    final int screenWidth= tileSize *maxScreenCol;
    final int screenHeight = tileSize *maxScreenRow;


    int FPS =60;

    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    Player player =new Player(this,keyH);
    int playerX=100;
    int playerY=100;
    int playerSpeed= 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new java.awt.Color(102, 140, 255));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta=0;
        long lastTime = System.nanoTime();
        long currnetTime ;
        int timer =0;
        int drawCount =0;

        while(gameThread != null){

            currnetTime = System.nanoTime();

            delta += (currnetTime - lastTime)/drawInterval;
//            timer += (currnetTime = lastTime);
            lastTime = currnetTime;

            if(delta>=1) {
                update();
                repaint();
                delta --;
                drawCount++;
            }
//
            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount=0;
                timer=0;
            }

        }
    }
    public void update(){

        player.update();

    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);


        Graphics2D g2  = (Graphics2D)g;

        player.draw(g2);

        g2.dispose();
    }
}

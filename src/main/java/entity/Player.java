package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{


    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public  void  setDefaultValues(){

        x=100;
        y=100;
        speed =4;
        direction="down";
    }
    public void getPlayerImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("character.png"));
            up2 =ImageIO.read(getClass().getResourceAsStream("character2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(){

        if (keyH.upPressed==true){
            y-=speed;
            direction ="up";
        } else if (keyH.downPressed==true) {
            y+=speed;
            direction ="down";
        } else if (keyH.leftPressed==true) {
            x-=speed;
            direction="left";
        } else if (keyH.rightPressed==true) {
            x+=speed;
            direction="right";
        }
    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y, gp.tileSize,gp.tileSize);
        BufferedImage image= null;
        switch (direction){
            case "up":
                image = up1;
            case "down":
                image = up1;
            case "right":
                image = up1;
            case "left":
                image = up1;
        }
        g2.drawImage(image, x,y,gp.tileSize,gp.tileSize, null);
    }
}

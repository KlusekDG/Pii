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
            up1 = ImageIO.read(getClass().getResourceAsStream("/character.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/character2.png"));

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
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum==1){
                spriteNum=2;
            } else if (spriteNum==2) {
                spriteNum=1;
            }
            spriteCounter=0;
        }
    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(x,y, gp.tileSize,gp.tileSize);
        BufferedImage image= null;
        switch (direction){
            case "up":
                if(spriteNum==1){
                    image = up1;
                }
                if (spriteNum==2){
                    image =up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image = up1;
                }
                if (spriteNum==2){
                    image =up2;
                };
                break;
            case "right":
                if(spriteNum==1){
                    image = up1;
                }
                if (spriteNum==2){
                    image =up2;
                };
                break;
            case "left":
                if(spriteNum==1){
                    image = up1;
                }
                if (spriteNum==2){
                    image =up2;
                };
                break;
        }
        g2.drawImage(image, x,y,gp.tileSize,gp.tileSize, null);
    }
}

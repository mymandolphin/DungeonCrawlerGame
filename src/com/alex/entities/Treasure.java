package com.alex.entities;

// imports
import com.alex.util.Vector;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author alex
 */
public class Treasure {
    
    // variables
    private Vector position;
    private int spriteWidth;
    private int spriteHeight;
    private boolean visible;
    
    private BufferedImage sprite;
    private int score;
    
    public Treasure(){
    
        position = new Vector(50,50);
        score = 50;
        visible = true;
        
        // load image
        try{
        
            sprite = ImageIO.read(getClass().getResourceAsStream("/Images/treasure.png"));
        
        } 
        catch (Exception ex){
        
            System.out.println(ex);
        
        }
        
        spriteWidth = sprite.getWidth();
        spriteHeight = sprite.getHeight();
    
    }
    
    public Treasure(Vector position){
    
        this.position = new Vector(position);
        this.score = 50;
        this.visible = true;
        
        // load image
        try {
        
            sprite = ImageIO.read(getClass().getResourceAsStream("/Images/treasure.png"));
        
        } catch (Exception ex){
        
            System.out.println(ex);
        
        }
    
        this.spriteWidth = sprite.getWidth();
        this.spriteHeight = sprite.getHeight();
        
    }
    
    public BufferedImage getSprite(){
    
        return this.sprite;
    
    }
    
    public int getSpriteWidth(){
       
        return this.spriteWidth;
    
    }
    
    public int getSpriteHeight(){
    
        return this.spriteHeight;
    
    }
    
    // return object boundaries
    public Rectangle getBounds(){
        
        Rectangle bounds = new Rectangle(position.getX(), position.getY(), spriteWidth, spriteHeight);
        return bounds;
    
    }
    
    public void setPosition(Vector v){
    
        position.toVector(v);
    
    }
    
    public Vector getPosition(){
    
        return position;
    
    }
    
    public void setScore(int newScore){
    
        score = newScore;
        
    }
    
    public int getScore(){
    
        return score;
    
    }
    
    public void setVisible(boolean vis){
    
        visible = vis;
    
    }
    
    public boolean getVisible(){
    
        return visible;
    
    }
    
    // draw treasure on canvas
    public void draw(Graphics2D graphic){
    
        if (visible == true){
        
            graphic.drawImage(sprite, position.getX(), position.getY(), null);
        
        }
    
    }
    
}

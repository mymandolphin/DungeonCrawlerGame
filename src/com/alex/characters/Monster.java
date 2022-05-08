/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.characters;

import com.alex.levels.Vector;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author alex
 */
public class Monster {
    
    String name;
    Vector position;
    int direction;
    int speed;
    int damage;
    boolean visible;
    int score;
    int spriteWidth;
    int spriteHeight;
    BufferedImage sprite;
    
    
    public Monster(){
    
        this.name = "Monster";
        this.position = new Vector(300,300);
        this.speed = 5;
        this.damage = 5;
        this.visible = true;
        this.score = 1;
        
        try{
        
            sprite = ImageIO.read(getClass().getResourceAsStream("/Images/monster.jpg"));
        
        } 
        catch (Exception ex){
        
            System.out.println(ex);
        
        }
        
        this.spriteWidth = sprite.getWidth();
        this.spriteHeight = sprite.getHeight();
    
    }
    
    public Monster(Vector pos, int damage){
    
        this.name = "Monster";
        this.position = pos;
        this.speed = 5;
        this.damage = damage;
        this.visible = true;
        this.score = 1;
        
        try{
        
            sprite = ImageIO.read(getClass().getResourceAsStream("/Images/monster.jpg"));
        
        } 
        catch (Exception ex){
        
            System.out.println(ex);
        
        }
        
        this.spriteWidth = sprite.getWidth();
        this.spriteHeight = sprite.getHeight();
    
    }
    
    public Rectangle getBounds(){
    
        Rectangle bounds = new Rectangle(this.position.getX(), this.position.getY(), this.spriteWidth, this.spriteHeight);
        
        return bounds;
    
    }
    
    public int getDamage(){
    
        return this.damage;
    
    }
    
    public void setDamage(int damage){
    
        this.damage = damage;
    
    }
    
    public int getSpeed(){
    
        return this.speed;
    
    }
    
    public void setSpeed(int speed){
    
        this.speed = speed;
    
    }
    
    public boolean isVisible(){
    
        return this.visible;
    
    }
    
    public void setVisible(boolean visible){
    
        this.visible = visible;
    
    }
    
    public int getScore(){
    
        return this.score;
    
    }
    
    public void setScore(int score){
    
        this.score = score;
    
    }
    
    public void move(int levelWidth, int levelHeight){
    
        Random random = new Random();
        int random_direction;
        
        Vector current_position = new Vector(this.position.getX(), this.position.getY());
        Vector displacement = new Vector();
        
        random_direction = random.nextInt(4);
        
        switch(random_direction){
        
            case 0:
                
                displacement.setY(-speed);
                break;
                
            case 1:
                
                displacement.setY(speed);
                break;
                
            case 2:
                
                displacement.setX(-speed);
                break;
                
            case 3:
                
                displacement.setX(speed);
                break;
        
        }
        
        if (current_position.getX() < (spriteWidth / 2)) {
        
            displacement.setX(1);
        
        } else if (current_position.getX() > levelWidth - (spriteWidth / 2)) {
        
            displacement.setX(-1);
        
        }
        
        if (current_position.getY() < (spriteWidth / 2)) {
        
            displacement.setY(1);
        
        } else if (current_position.getY() > levelWidth - (spriteWidth / 2)) {
        
            displacement.setY(-1);
        
        }
        
        current_position.add(displacement);
        
        this.position.toVector(current_position);
    
    }
    
    public void draw(Graphics2D g){
    
        if (this.visible == true){
        
            g.drawImage(sprite, this.position.getX(), this.position.getY(), null);
        
        }
    
    }
    
}
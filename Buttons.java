import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the buttons that the players interact with
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    public static boolean shopExists = false;
    
    public Buttons(GreenfootImage img){
        setImage(img);
    }
    
    public void updateImage(GreenfootImage img){
        setImage(img);
    }
}

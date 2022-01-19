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
    public GreenfootImage img;
    public boolean ifMoved = false;
    public boolean firstMove = true;
    
    public Buttons(GreenfootImage img){
        this.img = img;
        setImage(img);
    }
    
    public void act(){
        if (Greenfoot.mouseMoved(this))
        {
            if(firstMove){
                firstMove = false;
                ifMoved = true;
                Title.cursor.play();
                img.scale(img.getWidth() + 5, img.getHeight() +5);
                setImage(img);
            }
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            firstMove = true;
            if(ifMoved){
                ifMoved = false;
                img.scale(img.getWidth() - 5, img.getHeight() - 5);
                setImage(img);
            }
        }
    }
}

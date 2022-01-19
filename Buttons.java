import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the buttons that the players interact with
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    public static boolean shopExists = false; //check if Shop world already exists
    public GreenfootImage img; // image of Button
    public boolean ifMoved = false; // If the player moved from the button or not
    public boolean firstMove = true; // If the player hovers over the same button for two times consecutively, this would be false
    
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
                // Mouse hovers, then button enlarges
                img.scale(img.getWidth() + 5, img.getHeight() +5); 
                setImage(img);
            }
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            firstMove = true;
            if(ifMoved){
                ifMoved = false;
                // Mouse leaves button, then image returns to original size
                img.scale(img.getWidth() - 5, img.getHeight() - 5);
                setImage(img);
            }
        }
    }
}

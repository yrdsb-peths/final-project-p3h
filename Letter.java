import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the class that contains the letters in the Hangman game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Actor
{
    public String letter;
    public boolean picked = false; // see if this letter was selected by the player or not
 
    public GreenfootImage img; // See Buttons class for descriptions of these variables
    public boolean ifMoved = false;
    public boolean firstMove = true;
    public Letter(int index)
    {
        this("" + (char)(index + 65));
    }
    public Letter(String s)
    {
        letter = s;
        img = new GreenfootImage(letter, 42, Color.BLACK, new Color(0,0,0,0));
        setImage(img);
    }
    // return the updated image of the picked letter
    public void pickImage()
    {
        img = new GreenfootImage(letter, 42, Color.GRAY, new Color(0,0,0,0));
        setImage(img);
        picked = true;
    }
    // return if the letter was picked or not
    public boolean wasPicked()
    {
        return picked;
    }
    
    public void act(){
        if (!picked && Greenfoot.mouseMoved(this))
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
        if (!picked && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
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

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
 
    public Letter(int index)
    {
        this("" + (char)(index + 65));
    }
    public Letter(String s)
    {
        letter = s;
        setImage(new GreenfootImage(letter, 42, Color.BLACK, new Color(0,0,0,0)));
    }
    // return the updated image of the picked letter
    public void pickImage()
    {
        setImage(new GreenfootImage(letter, 42, Color.GRAY, new Color(0,0,0,0)));
    }
    // return if the letter was picked or not
    public boolean wasPicked()
    {
        return picked;
    }
}

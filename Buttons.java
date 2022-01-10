import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the buttons that the players interact with
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    public Buttons(String text, int fontSize, Color color){
        GreenfootImage button = new GreenfootImage(fontSize*2, fontSize*2);
        Font adjustedFont = new Font(true, false, fontSize);
        button.setFont(adjustedFont);
        button.setColor(color);
        button.fill();
        button.setColor(Color.BLACK);
        button.drawString(text, 0, fontSize);

        setImage(button);
    }
}

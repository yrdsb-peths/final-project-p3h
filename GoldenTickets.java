import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldenTickets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenTickets extends Actor
{
    public int numOfTickets = 100; 
    /**
     * Act - do whatever the GoldenTickets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage("Golden Tickets: " + numOfTickets, 30, new Color(227,190,43), new Color(0,0,0,0), Color.BLACK));
    }
    
    public int getTickets()
    {
        return numOfTickets;
    }
    
    public void setTickets(int num)
    {
        numOfTickets = num;
    }
}

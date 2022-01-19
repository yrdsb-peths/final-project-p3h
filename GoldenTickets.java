import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class contains the Golden Tickets, which is the currency of this game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenTickets extends Actor
{
    public static int numOfTickets = 100; // The player starts with 100 tickets
    /**
     * Act - do whatever the GoldenTickets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage("Golden Tickets: " + numOfTickets, 30, new Color(227,190,43), new Color(0,0,0,0), Color.BLACK));
    }
    // Returns the number of tickets
    public static int getTickets()
    {
        return numOfTickets;
    }
    // Sets the number of tickets
    public static void setTickets(int num)
    {
        numOfTickets = num;
    }
    // Adds a certain amount to the number of tickets
    public static void addTickets(int num)
    {
        numOfTickets += num;
    }
}

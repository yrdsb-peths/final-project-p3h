import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class contains the Golden Tickets, which is the currency of this game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenTickets extends Actor
{
    public static int numOfTickets = 100;
    
    public static boolean gained150 = false;
    public static boolean gained200 = false;
    /**
     * Act - do whatever the GoldenTickets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage("Golden Tickets: " + numOfTickets, 30, new Color(255, 186, 8), new Color(0,0,0,0), Color.BLACK));
        
        //Used for tracking achievements
        if(getTickets() >= 150)
        {
            gained150 = true;
        }
        if(getTickets() >= 200)
        {
            gained200 = true;
        }
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
        if(numOfTickets >= num)
        {
            numOfTickets += num;
        }
        else
        {
            setTickets(0);
        }
    }
    
}

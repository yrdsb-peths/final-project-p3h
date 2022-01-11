import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        addObject(GameHall.backtotitle, 100, 500);
    }
    
    public void act()
    {
        GameHall.checkPause();
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    public HashMap<Buttons,Integer> items = new HashMap<Buttons,Integer>();
    
    public List<Integer> boughtItems = new ArrayList<Integer>();
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        super(960, 540, 1); 
        
        addObject(GameHall.currency, 830, 520);
        
        //add buttons
        // add shop object into HashMap
        items.put(new Buttons(new GreenfootImage("goldenEgg.png")), 50);
        items.put(new Buttons(new GreenfootImage("laptop.png")), 20);
        items.put(new Buttons(new GreenfootImage("puppy.png")), 10);
        items.put(new Buttons(new GreenfootImage("mysteryBox.png")), 15);
        items.put(new Buttons(new GreenfootImage("garlicBread.png")), 5);
        items.put(new Buttons(new GreenfootImage("phone.png")), 30);
        
        //add shop objects onto world
        int row = 0;
        for(Buttons product : items.keySet())
        {
            int startX = getWidth()/2 - 200;
            if(row < 3){
                addObject(product, startX + row%3 * 200, 205);
            }
            else{
                addObject(product, startX + row%3 * 200, 420);
            }
            row++;
        }
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse == null) return;
            Actor actor = mouse.getActor();
            if(actor != null && actor instanceof Buttons) checkClick((Buttons)actor);
        }
    }
    
    private void checkClick(Buttons button)
    {
        int price = items.get(button);
        GoldenTickets.addTickets(-price);
        
        boughtItems.add(price);
        
        removeObject(button);
    }
}

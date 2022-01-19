import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The shop is where the player can buy items.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    // Save a reference to the previous shop world
    public static Shop shop;
    
    // All items in the shop corresponding to a specific price
    public HashMap<Buttons,Integer> items = new HashMap<Buttons,Integer>();
    // All items in the shop that are already bought by the player
    public static List<Integer> boughtItems = new ArrayList<Integer>();
    
    // Add items
        Buttons goldenEgg = new Buttons(new GreenfootImage("s-goldenEgg.png"));
        Buttons laptop = new Buttons(new GreenfootImage("s-laptop.png"));
        Buttons stuffy = new Buttons(new GreenfootImage("s-stuffy.png"));
        Buttons mysteryBox = new Buttons(new GreenfootImage("s-mysteryBox.png"));
        Buttons garlicBread = new Buttons(new GreenfootImage("s-garlicBread.png"));
        Buttons phone = new Buttons(new GreenfootImage("s-phone.png"));
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        super(960, 540, 1); 
        shop = this; // set reference to this world
 
        // add shop items & prices into HashMap
        items.put(goldenEgg, 50);
        items.put(laptop, 20);
        items.put(stuffy, 10);
        items.put(mysteryBox, 15);
        items.put(garlicBread, 5);
        items.put(phone, 30);
        
        //add shop items onto world
        int column = 0;
        for(Buttons product : items.keySet())
        {
            int startX = getWidth()/2 - 200;
            if(column < 3){
                addObject(product, startX + column%3 * 200, 205);
            }
            else{
                addObject(product, startX + column%3 * 200, 420);
            }
            column++;
        }
    }
    
    public void act()
    {
        addObject(GameHall.currency, 830, 520); 
        addObject(GameHall.backtoarcade, 100, 510);
        
        // If user pressed on any shop item
        if(Greenfoot.mouseClicked(goldenEgg)){
            check(goldenEgg);
        }
        if(Greenfoot.mouseClicked(laptop)){
            check(laptop);
        }
        if(Greenfoot.mouseClicked(stuffy)){
            check(stuffy);
        }
        if(Greenfoot.mouseClicked(garlicBread)){
            check(garlicBread);
        }
        if(Greenfoot.mouseClicked(phone)){
            check(phone);
        }
        if(Greenfoot.mouseClicked(mysteryBox)){
            check(mysteryBox);
        }
        
        GameHall.checkPause();
    }
    
    // This method checks if the player could buy the item
    private void check(Buttons button)
    {
         int price = items.get(button);
        if(GoldenTickets.getTickets() >= price) //if # of golden tickets is enough for the item
        {
            Title.cashSound.play();
            GoldenTickets.addTickets(-price); // deduce cost from golden tickets
            boughtItems.add(price); // add the item into list of bought items
            removeObject(button); // remove item from store
        }
    }
}

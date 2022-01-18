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
    public static Shop shop;
    
    public HashMap<Buttons,Integer> items = new HashMap<Buttons,Integer>();
    
    public static List<Integer> boughtItems = new ArrayList<Integer>();
    
    //add buttons
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
        shop = this;
 
        // add shop object into HashMap
        items.put(goldenEgg, 50);
        items.put(laptop, 20);
        items.put(stuffy, 10);
        items.put(mysteryBox, 15);
        items.put(garlicBread, 5);
        items.put(phone, 30);
        
        //add shop objects onto world
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
    
    private void check(Buttons button)
    {
        
        int price = items.get(button);
        GoldenTickets.addTickets(-price);
        
        boughtItems.add(price);
        
        removeObject(button);
    }
}

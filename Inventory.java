import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends World
{
    private int[] prices = new int[Shop.boughtItems.size()];
    private HashMap<Integer, Buttons> itemImg = new HashMap<Integer, Buttons>();
    private ArrayList<Buttons> items = new ArrayList<Buttons>();
    
    /**
     * Constructor for objects of class Inventory.
     * 
     */
    public Inventory()
    {    
        super(960, 540, 1); 
        
        addObject(GameHall.backtotitle, 100, 30);
        
        // Add buttons into HashMap
        itemImg.put(50, new Buttons(new GreenfootImage("i-goldenEgg.png")));
        itemImg.put(10, new Buttons(new GreenfootImage("i-stuffy.png")));
        itemImg.put(20, new Buttons(new GreenfootImage("i-laptop.png")));
        itemImg.put(15, new Buttons(new GreenfootImage("i-mysteryBox.png")));
        itemImg.put(5, new Buttons(new GreenfootImage("i-garlicBread.png")));
        itemImg.put(30, new Buttons(new GreenfootImage("i-phone.png")));
        
        //Initialize array from shop
        int x = 0;
        for(int n : Shop.boughtItems)
        {
             prices[x] = n;
             x++;
        }
        
        // Merge sort the array from smallest to largest price
        MergeSort.mergeSort(prices);
        
        // Find all the bought items and show it in the inventory
        if(prices.length == 0){
            Buttons noItems = new Buttons(new GreenfootImage("You haven't bought anything yet", 42, Color.BLACK, new Color(0,0,0,0)));
            addObject(noItems, 480, 160);
        }
        for(int n : prices)
        {
            items.add(itemImg.get(n));
        }
        int place = 0; 
        for(Buttons item : items)
        {
            int startX = getWidth()/2 - 200;
            if(place < 2){
                addObject(item, startX + place%2 * 400, 220);
            }
            else if (place >= 2 && place < 4){
                addObject(item, startX + place%2 * 400, 320);
            }
            else{
                addObject(item, startX + place%2 * 400, 420);
            }
            place++;
        }
    }
    
    public void act()
    {
        GameHall.checkPause();
    }
}

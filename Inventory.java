import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the inventory that stores items the player bought in Shop.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory extends World
{
    // Initialize array that contains prices of bought items
    private int[] prices = new int[Shop.boughtItems.size()];
    // Initialize HashMap that contains inventory items
    private HashMap<Integer, Picture> itemImg = new HashMap<Integer, Picture>();
    // Initialize ArrayList for inventory items
    private ArrayList<Picture> items = new ArrayList<Picture>();
    /**
     * Constructor for objects of class Inventory.
     * 
     */
    public Inventory()
    {    
        super(960, 540, 1); 
        
        addObject(GameHall.backtotitle, 840, 80);
        
        // Add buttons into HashMap
        itemImg.put(50, new Picture(new GreenfootImage("i-goldenEgg.png")));
        itemImg.put(10, new Picture(new GreenfootImage("i-stuffy.png")));
        itemImg.put(20, new Picture(new GreenfootImage("i-laptop.png")));
        itemImg.put(15, new Picture(new GreenfootImage("i-mysteryBox.png")));
        itemImg.put(5, new Picture(new GreenfootImage("i-garlicBread.png")));
        itemImg.put(30, new Picture(new GreenfootImage("i-phone.png")));
        
        //Initialize array from Shop
        int x = 0;
        for(int n : Shop.boughtItems){
             prices[x] = n;
             x++;
        }
        
        // Merge sort the array from smallest to largest price
        MergeSort.sort(prices);
        
        // Find all the bought items and show it in the inventory
        if(prices.length == 0){ // if the player didn't buy anything yet
            Picture noItems = new Picture(new GreenfootImage("You haven't bought anything yet", 32, new Color(255, 222, 89), new Color(0,0,0,0)));
            addObject(noItems, 510, 80);
        }
        for(int n : prices) // add the prices into the ArrayList to keep the correct order
        {
            items.add(itemImg.get(n));
        }
        int place = 0; 
        for(Picture item : items) // shows the pictures onto the World
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

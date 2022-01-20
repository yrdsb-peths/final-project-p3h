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
    private HashMap<Integer, InventoryItem> itemImg = new HashMap<Integer, InventoryItem>();
    // Initialize ArrayList for inventory items
    private ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
    /**
     * Constructor for objects of class Inventory.
     * 
     */
    public Inventory()
    {    
        super(960, 540, 1); 
        
        addObject(GameHall.backToArcade, 840, 80);
        
        // Add buttons into HashMap
        itemImg.put(Shop.pusheenP, (new InventoryItem(new GreenfootImage("Pusheen.png"), "Pusheen", Shop.pusheenP)));
        itemImg.put(Shop.doraemonP, (new InventoryItem(new GreenfootImage("Doraemon.png"), "Doraemon", Shop.doraemonP)));
        itemImg.put(Shop.minionsP, (new InventoryItem(new GreenfootImage("Minions.jpg"), "Minions", Shop.minionsP)));
        itemImg.put(Shop.bulbasaurP, (new InventoryItem(new GreenfootImage("Bulbasaur.png"), "Bulbasaur", Shop.bulbasaurP)));
        itemImg.put(Shop.pikachuP, (new InventoryItem(new GreenfootImage("Pikachu.png"), "Pikachu", Shop.pikachuP)));
        itemImg.put(Shop.bareBearsP, (new InventoryItem(new GreenfootImage("BareBears.jpg"), "We Bare Bears", Shop.bareBearsP)));
        
        
        
        //Initialize array from Shop
        int x = 0;
        for(int n : Shop.boughtItems){
             prices[x] = n;
             x++;
        }
        
        // Merge sort the array from smallest to largest price
        MergeSort.sort(prices);
        
        // Find all the bought items and show it in the inventory
        for(int n : prices) // add the prices into the ArrayList to keep the correct order
        {
            items.add(itemImg.get(n));
        }
        int place = 0; 
        for(InventoryItem item : items) // shows the pictures onto the World
        {
            int startX = 276;
            if(place < 2){
                addObject(item, startX + place%2 * 423, 197);
            }
            else if (place >= 2 && place < 4){
                addObject(item, startX + place%2 * 423, 307);
            }
            else{
                addObject(item, startX + place%2 * 423, 417);
            }
            place++;
        }
    }
    
    public void act()
    {
        GameHall.checkPause();
    }
}

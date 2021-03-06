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
    
    // Maps all items in the shop (key) corresponding to a specific price (value)
    public HashMap<ShopItem,Integer> items = new HashMap<ShopItem,Integer>();
    // All items in the shop that are already bought by the player
    public static List<Integer> boughtItems = new ArrayList<Integer>();
        
    //Item Prices
    public static final int doraemonP = 20;
    public static final int minionsP = 25;
    public static final int pusheenP = 30;
    public static final int bulbasaurP = 35;
    public static final int pikachuP = 40;
    public static final int bareBearsP = 50;
    
    // Add items
    ShopItem doraemon = new ShopItem(new GreenfootImage("Doraemon.png"), doraemonP);
    ShopItem minions  = new ShopItem(new GreenfootImage("Minions.jpg"), minionsP);
    ShopItem pusheen = new ShopItem(new GreenfootImage("Pusheen.png"), pusheenP);
    ShopItem bulbasaur = new ShopItem(new GreenfootImage("Bulbasaur.png"), bulbasaurP);
    ShopItem pikachu = new ShopItem(new GreenfootImage("Pikachu.png"), pikachuP);
    ShopItem bareBears = new ShopItem(new GreenfootImage("BareBears.jpg"), bareBearsP);
        
    //Cheat: makes sure player could only use the cheat once
    boolean cheated = false;
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        super(960, 540, 1); 
        shop = this; // set reference to this world
 
        // add shop items & prices into HashMap
        items.put(pusheen, pusheenP);
        items.put(pikachu, pikachuP);
        items.put(bulbasaur, bulbasaurP);
        items.put(bareBears, bareBearsP);
        items.put(doraemon, doraemonP);
        items.put(minions, minionsP);
        
        //add shop items onto world
        int column = 0;
        for(ShopItem product : items.keySet())
        {
            int startX = getWidth()/2 - 110;
            if(column < 3){
                addObject(product, startX + column%3 * 230, 145);
            }
            else{
                addObject(product, startX + column%3 * 230, 400);
            }
            column++;
        }
    }
    
    public void act()
    {
        addObject(GameHall.currency, 125, 450); 
        addObject(GameHall.backToArcade, 125, 500);
                
        // If user pressed on any shop item
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse == null) return;
            Actor actor = mouse.getActor();
            if(actor != null && actor instanceof ShopItem)
            {
                check((ShopItem)actor);
            }
        }
        checkCheat();
        GameHall.checkPause();
    }
    
    // This method checks if the player could buy the item
    private void check(ShopItem item)
    {
        int price = items.get(item);
        if(GoldenTickets.getTickets() >= price && !item.bought) //if # of golden tickets is enough for the item & item is not bought
        {
            Title.cashSound.play();
            GoldenTickets.setTickets(GoldenTickets.getTickets()-price); // deduce cost from golden tickets
            boughtItems.add(price); // add the item into list of bought items
            item.soldOut();
        }
    }
    
    //This method allows the player to earn 100 Golden Tickets with the cheat code
    private void checkCheat()
    {
        if(!cheated && Greenfoot.isKeyDown("SPACE")) {
            GoldenTickets.setTickets(GoldenTickets.getTickets() + 100);
            cheated = true;
        }
    }
}

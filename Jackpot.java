import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player can spin a jackpot spinner
 * 
 * @author Melanie
 * @version 1
 */
public class Jackpot extends World
{
    private GreenfootImage[][] spinner = new GreenfootImage[3][6];
    
    private GreenfootImage w = new GreenfootImage("Jackpot-W.png");
    private GreenfootImage i = new GreenfootImage("Jackpot-I.png");
    private GreenfootImage n = new GreenfootImage("Jackpot-N.png");
    private GreenfootImage coin = new GreenfootImage("Jackpot-Coin.png");
    private GreenfootImage coinStack = new GreenfootImage("Jackpot-CoinStack.png");
    private GreenfootImage x = new GreenfootImage("Jackpot-X.png");
    private GreenfootImage bomb = new GreenfootImage("Jackpot-Bomb.png");
    private GreenfootImage spinning = new GreenfootImage("Jackpot-Spinning.png");
    
    //Starting tiles to be displayed 
    private Picture spinW = new Picture(w);
    private Picture spinI = new Picture(i);
    private Picture spinN = new Picture(n);
    
    private Buttons spin = new Buttons(new GreenfootImage("SpinButton-U.png"));
    private GreenfootImage spinButton;
    
    private Color yellow = new Color(255, 222, 89);
    
    private Buttons prizeList = new Buttons(new GreenfootImage("question.png"));
    private Buttons backToJackpot = new Buttons(new GreenfootImage("BackToJackpotButton.png"));
    
    public static boolean gainedWin = false;
    /**
     * Constructor for objects of class Jackpot.
     * 
     */
    public Jackpot()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        
        addObject(prizeList, 930, 30);
        
        //Fill spinner array
        spinner[0][0] = w;
        spinner[1][0] = i;
        spinner[2][0] = n;  
        addImageArray(spinner, coin, 1);
        addImageArray(spinner, coinStack, 2);
        addImageArray(spinner, x, 3);
        addImageArray(spinner, bomb, 4);
        addImageArray(spinner, spinning, 5);
        
        //Set up initial tiles
        addObject(spinW, 150, 318);
        addObject(spinI, 357, 318);
        addObject(spinN, 564, 318);
        addObject(spin, 820, 318);
        
        //Add Golden tickets Counter
        addObject(GameHall.currency, 150, 500);
        
        //Add back to title button
        addObject(GameHall.backToArcade, 820, 500);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(prizeList))
        {
            Title.click.play();
            addObject(new Picture(new GreenfootImage("PrizeList.png")), 480, 270);
            addObject(backToJackpot, 820, 50);
        }
        if(Greenfoot.mouseClicked(backToJackpot))
        {
                Greenfoot.setWorld(new Jackpot());
        }
        
        if(Greenfoot.mouseClicked(spin))
        {
            if(GoldenTickets.getTickets() >= 5)
            {
                removeObjects(getObjectsAt(600, 100, null));
                
                //Deducts cost to run Jackpot
                GoldenTickets.addTickets(-5);     
                Title.cashSound.play();
                
                removeObject(spinW);
                removeObject(spinI);
                removeObject(spinN);
                
                //Display "spinning" pictures so that it looks like the spinner is moving
                for(int i = 0; i < 3; i++)
                {
                    addObject(new Picture(spinner[i][5]), 150 + i * 204, 318);
                }
                Greenfoot.delay(20);
                //Remove the spinning pictures
                for(int i = 0; i < 3; i++)
                {
                    removeObjects(getObjectsAt(150 + i * 204, 318, null));
                }
                
                //Generate a random tile in each column and use the array nums 
                //to keep track of the columns selected(will use later)
                int[] nums = new int[3];
                for(int i = 0; i < 3; i++)
                {
                    int rand = Greenfoot.getRandomNumber(5);
                    nums[i] = rand;
                    addObject(new Picture(spinner[i][rand]), 150 + i * 204, 318);
                }
                
                //Use array nums to determine the prize/tickets deducted
                //WIN combo Tiles = 50GTS
                if(nums[0] == 0 && nums[1] == 0 && nums[2] == 0)
                {
                    GoldenTickets.addTickets(50);
                    gainedWin = true;
                    addObject(new Picture(new GreenfootImage("Congrats! You have won 50 Golden Tickets"
                            ,30, yellow, new Color(0,0,0,0))), 650, 100);
                }
                int numTickets = 0;
                //Any coin tile = 5GT
                numTickets += checkTiles(1, nums, 5);
                //Any coin stack Tile = 10GT
                numTickets += checkTiles(2, nums, 10);
                //3 Xs = no prize nor loss
                //Any bomb = -10GT
                numTickets += checkTiles(4, nums, -10);
                
                if(numTickets > 0)
                {
                    addObject(new Picture(new GreenfootImage("Congrats! You have won " + numTickets + " Golden Tickets"
                                ,30, yellow, new Color(0,0,0,0))), 600, 100);
                }
                else if(numTickets < 0)
                {
                    int absoluteVal = numTickets * -1;
                    addObject(new Picture(new GreenfootImage("Oh no! You have lost " + absoluteVal + " Golden Tickets"
                                ,30, yellow, new Color(0,0,0,0))), 600, 100);
                }
                else if(numTickets == 0)
                {
                    addObject(new Picture(new GreenfootImage("Oh no! You have not won any Golden Tickets"
                                ,30, yellow, new Color(0,0,0,0))), 600, 100);
                }
                GoldenTickets.addTickets(numTickets);
                
                //Set game as played
                Title.gamesPlayed[2] = true;
            }
        }
        GameHall.checkPause();
    }
    
    private int checkTiles(int n, int[] nums, int prize)
    {
        int counter = 0;
        for(int num: nums)
        {
            if(num == n)
            {
                counter++;
            }
        }
        return counter * prize;
    }
    
    //Duplicate image to all 3 rows of an array at column c
    private void addImageArray(GreenfootImage[][] arr, GreenfootImage img, int c)
    {
        for(int i = 0; i < 3; i++)
        {
            arr[i][c] = img;
        }
    }
}

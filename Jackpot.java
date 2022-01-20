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
    private JackpotTile spinW = new JackpotTile(w);
    private JackpotTile spinI = new JackpotTile(i);
    private JackpotTile spinN = new JackpotTile(n);
        
    private Buttons spin = new Buttons(new GreenfootImage("SpinButton-U.png"));
    private GreenfootImage spinButton;
    
    public static boolean gainedWin = false;
    /**
     * Constructor for objects of class Jackpot.
     * 
     */
    public Jackpot()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        setBackground(new GreenfootImage("JackpotWorld.png"));
        
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
        addObject(GameHall.backtoarcade, 820, 500);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(spin))
        {
            if(GoldenTickets.getTickets() >= 5)
            {
                //Deducts cost to run Jackpot
                GoldenTickets.addTickets(-5);     
                Title.cashSound.play();
                
                removeObject(spinW);
                removeObject(spinI);
                removeObject(spinN);
                
                //Display "spinning" pictures so that it looks like the spinner is moving
                for(int i = 0; i < 3; i++)
                {
                    addObject(new JackpotTile(spinner[i][5]), 150 + i * 204, 318);
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
                    addObject(new JackpotTile(spinner[i][rand]), 150 + i * 204, 318);
                }
                
                //Use array nums to determine the prize/tickets deducted
                //3 Xs = no prize nor loss
                if(nums[0] == 0 || nums[1] == 0 || nums[2] == 0)
                {
                    GoldenTickets.addTickets(50);
                    gainedWin = true;
                }
                if(nums[0] == 1 || nums[1] == 1 || nums[2] == 1)
                {
                    GoldenTickets.addTickets(10);
                }
                else if(nums[0] == 2 || nums[1] == 2 || nums[2] == 2)
                {
                    GoldenTickets.addTickets(15);
                }
                else if(nums[0] == 4 || nums[1] == 4 || nums[2] == 4)
                {
                    if(GoldenTickets.getTickets() >= 10)
                    {
                        GoldenTickets.addTickets(-10);
                    }
                    else
                    {
                        GoldenTickets.setTickets(0);
                    }
                }
                
                //Set game as played
                Title.gamesPlayed[2] = true;
            }
        }
        GameHall.checkPause();
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

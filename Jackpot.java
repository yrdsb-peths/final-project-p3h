import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player can spin a jackpot spinner
 * 
 * @author Melanie
 * @version 1
 */
public class Jackpot extends World
{
    private JackpotTile[][] spinner = new JackpotTile[3][6];
    
    private JackpotTile spinW = new JackpotTile(new GreenfootImage("Jackpot-W.png"));
    private JackpotTile spinI = new JackpotTile(new GreenfootImage("Jackpot-I.png"));
    private JackpotTile spinN = new JackpotTile(new GreenfootImage("Jackpot-N.png"));
    private JackpotTile spinCoin = new JackpotTile(new GreenfootImage("Jackpot-Coin.png"));
    private JackpotTile spinCoinStack = new JackpotTile(new GreenfootImage("Jackpot-CoinStack.png"));
    private JackpotTile spinX = new JackpotTile(new GreenfootImage("Jackpot-X.png"));
    private JackpotTile spinBomb = new JackpotTile(new GreenfootImage("Jackpot-Bomb.png"));
    private JackpotTile spinSpinning = new JackpotTile(new GreenfootImage("Jackpot-Spinning.png"));
    
    private GreenfootImage spinButton;
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
        spinner[0][0] = spinW;
        spinner[1][0] = spinI;
        spinner[2][0] = spinN;
        addTileArray(spinner, spinCoin, 1);
        addTileArray(spinner, spinCoinStack, 2);
        addTileArray(spinner, spinX, 3);
        addTileArray(spinner, spinBomb, 4);
        addTileArray(spinner, spinSpinning, 5);
        
        addObject(spinW, 150, 318);
        addObject(spinI, 357, 318);
        addObject(spinN, 565, 318);
    }
    
    public void act()
    {
        if(true)
        {
            
        }
    }
    
    //Update the tiles
    private void updateTiles(JackpotTile newTile)
    {
        
    }
    
    //Add tile to all 3 rows of an array at column c
    private void addTileArray(JackpotTile[][] arr, JackpotTile tile, int c)
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i][c] = tile;
        }
    }
}

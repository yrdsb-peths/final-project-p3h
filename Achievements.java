import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Achievements page keeps track of the achievements the player has reached
 * 
 * @Melanie
 */
public class Achievements extends World
{
    //Greyed Out Achievements
    public final int fg_FULL = 1;
    public final int ag_FULL = 4;
    public final int gt100_FULL = 150;
    public final int gt200_FULL = 200;
    public final int gp_FULL = 1;
    public final int mg_FULL = 1;
    public final int fi_FULL = 1;
    public final int ai_FULL = 6;
    
    public Achievement fg = new Achievement(new GreenfootImage("Achievement-FG.png"), 0, fg_FULL);
    public Achievement ag = new Achievement(new GreenfootImage("Achievement-AG.png"), 0, ag_FULL);
    public Achievement gt150 = new Achievement(new GreenfootImage("Achievement-GT150.png"), 0, gt100_FULL);
    public Achievement gt200 = new Achievement(new GreenfootImage("Achievement-GT200.png"), 0, gt200_FULL);
    public Achievement gp = new Achievement(new GreenfootImage("Achievement-GP.png"), 0, gp_FULL);
    public Achievement mg = new Achievement(new GreenfootImage("Achievement-MG.png"), 0, mg_FULL);
    public Achievement fi = new Achievement(new GreenfootImage("Achievement-FI.png"), 0, fi_FULL);
    public Achievement ai = new Achievement(new GreenfootImage("Achievement-AI.png"), 0, ai_FULL);
    /**
     * Constructor for objects of class Achievements.
     * 
     */
    public Achievements()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        //Set up greyed achievements 
        addObject(fg, 263, 183);
        addObject(ag, 263, 276);
        addObject(gt150, 263, 370);
        addObject(gt200, 263, 464);
        addObject(gp, 689, 183);
        addObject(mg, 689, 276);
        addObject(fi, 689, 370);
        addObject(ai, 689, 464);
        addObject(GameHall.backToArcade, 520, 100);
        
        //Show latest achievements
        addAchievements();
    }
    
    public void act()
    {
        GameHall.checkPause();
    }
    
    public void addAchievements()
    {
        int gt = GoldenTickets.getTickets();
        //Played First Game
        if(numGamesPlayed() >= 1)
        {
            removeObject(fg);
        }
        //Played all games
        if(numGamesPlayed() == 4)
        {
            removeObject(ag);
        }
        else
        {
            ag.setProgress(numGamesPlayed());
        }
        //Gained 150 Golden Tickets
        if(GoldenTickets.gained150)
        {
            removeObject(gt150);
        }
        else
        {
            gt150.setProgress(gt);
        }
        //Gained 200 Golden Tickets
        if(GoldenTickets.gained200)
        {
            removeObject(gt200);
        }
        else
        {
            gt200.setProgress(gt);
        }
        //Gained the WIN combo in Jackpot Game
        if(Jackpot.gainedWin)
        {
            removeObject(gp);
        }
        //Completed the memory game in less that 30s
        if(MemoryGame.timeBelow30)
        {
            removeObject(mg);
        }
        //Bought first item from shop
        if(Shop.boughtItems.size() >= 1)
        {
            removeObject(fi);
        }
        //Bought all items from shop
        if(Shop.boughtItems.size() == 6)
        {
            removeObject(ai);
        }
        else
        {
            ai.setProgress(Shop.boughtItems.size());
        }
    }
        
    //Check the number of games played
    private int numGamesPlayed()
    {
        int counter = 0;
        for(boolean game: Title.gamesPlayed)
        {
            if(game)
            {
                counter++;
            }
        }
        return counter;
    }
}

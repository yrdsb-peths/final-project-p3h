import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Achievements page keeps track of the achievements the player has reached
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Achievements extends World
{
    //Greyed Out Achievements
    public final int fg_FULL = 1;
    public final int ag_FULL = 5;
    public final int gt100_FULL = 100;
    public final int gt200_FULL = 200;
    public final int gp_FULL = 1;
    public final int mg_FULL = 1;
    public final int fi_FULL = 1;
    public final int ai_FULL = 6;
    
    public Achievement fg = new Achievement(new GreenfootImage("Achievement-FG.png"), 0, fg_FULL);
    public Achievement ag = new Achievement(new GreenfootImage("Achievement-AG.png"), 0, ag_FULL);
    public Achievement gt100 = new Achievement(new GreenfootImage("Achievement-GT100.png"), 0, gt100_FULL);
    public Achievement gt200 = new Achievement(new GreenfootImage("Achievement-GT200.png"), 0, gt200_FULL);
    public Achievement gp = new Achievement(new GreenfootImage("Achievement-GP.png"), 0, gp_FULL);
    public Achievement mg = new Achievement(new GreenfootImage("Achievement-MG.png"), 0, mg_FULL);
    public Achievement fi = new Achievement(new GreenfootImage("Achievement-FI.png"), 0, fi_FULL);
    public Achievement ai = new Achievement(new GreenfootImage("Achievement-AI.png"), 0, ai_FULL);
    
    public static Buttons backtotitle = new Buttons(new GreenfootImage("BackToTitle.png"));
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
        addObject(gt100, 263, 370);
        addObject(gt200, 263, 464);
        addObject(gp, 690, 183);
        addObject(mg, 690, 276);
        addObject(fi, 690, 370);
        addObject(ai, 690, 464);
        addObject(backtotitle, 520, 100);
        
        //Show latest achievements
        addAchievements();
    }
    
    public void act()
    {
        
    }
    
    public void addAchievements()
    {
        int gt = GoldenTickets.getTickets();
        if(checkGamePlayed())
        {
            removeObject(fg);
        }
        if(allGamesPlayed())
        {
            removeObject(ag);
        }
        if(gt >= 100)
        {
            removeObject(gt100);
        }
        if(gt >= 200)
        {
            removeObject(gt200);
        }
        
        if(Greenfoot.mouseClicked(backtotitle))
        {
            Greenfoot.setWorld(new Title());
        }
    }
    
    //Check if at least one game is played
    private boolean checkGamePlayed()
    {
        for(boolean game: Title.gamesPlayed)
        {
            if(game)
            {
                return true;
            }
        }
        return false;
    }
    
    //Check if all games are played
    private boolean allGamesPlayed()
    {
        for(boolean game: Title.gamesPlayed)
        {
            if(!game)
            {
                return false;
            }
        }
        return true;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameHall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameHall extends World
{
    private Buttons memoryCard = new Buttons(new GreenfootImage("memorycardbutton.png"));
    private Buttons rockpaperscissors = new Buttons(new GreenfootImage("rockpaperscissorsbutton.png"));
    private Buttons jackpot = new Buttons(new GreenfootImage("jackpot.png"));
    private Buttons trivia = new Buttons(new GreenfootImage("triviabutton.png"));
    
    public Buttons pausemenu = new Buttons(new GreenfootImage("pausemenu.png"));
    public static Buttons resume = new Buttons(new GreenfootImage("resumebutton.png"));
    public static Buttons backtotitle = new Buttons(new GreenfootImage("BackToTitle.png"));
    private Buttons shop = new Buttons(new GreenfootImage("shop.png"));
    
    private int pauseOption = 1;
    private boolean pause = false;
    private boolean isDown = false;
    
    public static GoldenTickets currency = new GoldenTickets();
    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public GameHall()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        //add games
        addObject(memoryCard, 330, 250);
        addObject(rockpaperscissors, 430, 250);
        addObject(jackpot, 530, 250);
        addObject(trivia, 630, 250);
        //add pause menu & shop
        addObject(pausemenu, 400, 480);
        addObject(shop, 560, 480);
        
        
    }
    
    public void act()
    {
        //show currency
        addObject(currency, 130, 500);
        if(Greenfoot.mouseClicked(memoryCard))
        {
            Greenfoot.setWorld(new MemoryGame());
        }
        else if(Greenfoot.mouseClicked(rockpaperscissors))
        {
            Greenfoot.setWorld(new RockPaperScissor());
        }
        else if(Greenfoot.mouseClicked(trivia))
        {
            //Greenfoot.setWorld(new Trivia());
        }
        else if(Greenfoot.mouseClicked(jackpot))
        {
            //Greenfoot.setWorld(new Jackpot());
        }

        if(Greenfoot.mouseClicked(shop))
        {
            Greenfoot.setWorld(new Shop());
        }
        if(Greenfoot.mouseClicked(pausemenu))
        {
            drawPauseMenu();
        }
        checkPause();
    }
    
    public void drawPauseMenu(){
        removeObjects(getObjects(null));
   
        addObject(new Buttons(new GreenfootImage("menuscreen.png")), 480, 270);
        addObject(resume, 480, 240);
        //addObject(new Buttons(new GreenfootImage("Menu-music" + ((TitleScreen.bgm.isPlaying()) ? "On" : "Off") + ".png")));
        addObject(backtotitle, 480, 300);
    }
    
    public static void checkPause(){
        if(Greenfoot.mouseClicked(resume))
        {
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(backtotitle))
        {
            Greenfoot.setWorld(new Title());
        }
        
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameHall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameHall extends World
{
    private Buttons memoryGame = new Buttons(new GreenfootImage("MemoryGame.png"));
    private Buttons rps = new Buttons(new GreenfootImage("RPS.png"));
    private Buttons jackpot = new Buttons(new GreenfootImage("Jackpot.png"));
    private Buttons hangman = new Buttons(new GreenfootImage("Hangman.png"));
    
    private Buttons pausemenu = new Buttons(new GreenfootImage("MenuButton.png"));
    private Buttons achievements = new Buttons(new GreenfootImage("AchievementsButton.png"));
    private Buttons shop = new Buttons(new GreenfootImage("ShopButton.png"));
    private Buttons inventory = new Buttons(new GreenfootImage("InventoryButton.png"));
    
    public static Buttons resume = new Buttons(new GreenfootImage("resumebutton.png"));
    public static Buttons backtotitle = new Buttons(new GreenfootImage("BackToTitle.png"));
    public static Buttons backtoarcade = new Buttons(new GreenfootImage("BackToArcade.png"));
    public Buttons musicOnMenu = new Buttons(new GreenfootImage("Menu-musicOn.png"));
    public Buttons musicOffMenu = new Buttons(new GreenfootImage("Menu-musicOff.png"));
    
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
        addObject(memoryGame, 199, 220);
        addObject(rps, 466, 220);
        addObject(hangman, 199, 384);
        addObject(jackpot, 466, 384);
        //add pause menu & shop
        addObject(pausemenu, 760, 92);
        addObject(achievements, 760, 205);
        addObject(shop, 760, 318);
        addObject(inventory, 760, 432);
        
    }
    
    public void act()
    {
        //show currency
        addObject(currency, 130, 500);
        if(Greenfoot.mouseClicked(memoryGame))
        {
            Title.click.play();
            Greenfoot.setWorld(new MemoryGame());
        }
        else if(Greenfoot.mouseClicked(rps))
        {
            Title.click.play();
            Greenfoot.setWorld(new RockPaperScissor());
        }
        else if(Greenfoot.mouseClicked(hangman))
        {
            Title.click.play();
            Greenfoot.setWorld(new HangMan());
        }
        else if(Greenfoot.mouseClicked(jackpot))
        {
            Title.click.play();
            Greenfoot.setWorld(new Jackpot());
        }

        if(Greenfoot.mouseClicked(shop))
        {
            Title.click.play();
            if(!Buttons.shopExists)
            {
                Buttons.shopExists = true;
                Greenfoot.setWorld(new Shop());
            }
            else Greenfoot.setWorld(Shop.shop);
        }
        if(Greenfoot.mouseClicked(pausemenu))
        {
            Title.click.play();
            drawPauseMenu();
        }
        if(Greenfoot.mouseClicked(musicOnMenu)){
            Title.bgm.pause();
            addObject(musicOffMenu, 480, 300);
            removeObject(musicOnMenu);
        }
        if(Greenfoot.mouseClicked(musicOffMenu)){
            Title.bgm.playLoop();
            addObject(musicOnMenu, 480, 300);
            removeObject(musicOffMenu);
        }
        checkPause();
    }
    
    public void drawPauseMenu(){
        removeObjects(getObjects(null));
   
        addObject(new Buttons(new GreenfootImage("menuscreen.png")), 480, 270);
        addObject(resume, 480, 240);
        if(Title.bgm.isPlaying()) addObject(musicOnMenu, 480, 300);
        else addObject(musicOffMenu, 480, 300);
        addObject(backtotitle, 480, 360);
    }
    
    public static void checkPause(){
        if(Greenfoot.mouseClicked(resume))
        {
            Title.click.play();
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(backtotitle))
        {
            Title.click.play();
            Greenfoot.setWorld(new Title());
        }
        if(Greenfoot.mouseClicked(backtoarcade))
        {
            Title.click.play();
            Greenfoot.setWorld(new GameHall());
        }
    }
}

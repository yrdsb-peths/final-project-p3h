import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The GameHall contains all mini games, the menu, and the shop
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameHall extends World
{
    // Mini games
    private Buttons memoryCard = new Buttons(new GreenfootImage("memorycardbutton.png"));
    private Buttons rockpaperscissors = new Buttons(new GreenfootImage("rockpaperscissorsbutton.png"));
    private Buttons jackpot = new Buttons(new GreenfootImage("jackpot.png"));
    private Buttons trivia = new Buttons(new GreenfootImage("triviabutton.png"));
    
    // Menu & Shop buttons
    public Buttons pausemenu = new Buttons(new GreenfootImage("pausemenu.png"));
    public static Buttons resume = new Buttons(new GreenfootImage("resumebutton.png"));
    public static Buttons backtotitle = new Buttons(new GreenfootImage("BackToTitle.png"));
    public static Buttons backtoarcade = new Buttons(new GreenfootImage("BackToArcade.png"));
    public Buttons musicOnMenu = new Buttons(new GreenfootImage("Menu-musicOn.png"));
    public Buttons musicOffMenu = new Buttons(new GreenfootImage("Menu-musicOff.png"));
    private Buttons shop = new Buttons(new GreenfootImage("shop.png"));
    
    // Amount of Golden Tickets the player has
    public static GoldenTickets currency = new GoldenTickets();
    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public GameHall()
    {    
        super(960, 540, 1); 
        
        //add mini game buttons
        addObject(memoryCard, 330, 250);
        addObject(rockpaperscissors, 430, 250);
        addObject(jackpot, 530, 250);
        addObject(trivia, 630, 250);
        
        //add pause menu & shop buttons
        addObject(pausemenu, 400, 480);
        addObject(shop, 560, 480);
    }
    
    public void act()
    {
        //show Golden Tickets
        addObject(currency, 130, 500);
        
        // Mini game buttons transport the player to the mini game world
        if(Greenfoot.mouseClicked(memoryCard))
        {
            Title.click.play();
            Greenfoot.setWorld(new MemoryGame());
        }
        else if(Greenfoot.mouseClicked(rockpaperscissors))
        {
            Title.click.play();
            Greenfoot.setWorld(new RockPaperScissor());
        }
        else if(Greenfoot.mouseClicked(trivia))
        {
            Title.click.play();
            Greenfoot.setWorld(new HangMan());
        }
        else if(Greenfoot.mouseClicked(jackpot))
        {
            Title.click.play();
            Greenfoot.setWorld(new Jackpot());
        }
        // Shop
        if(Greenfoot.mouseClicked(shop))
        {
            Title.click.play();
            if(!Buttons.shopExists) //initialize a new shop
            {
                Buttons.shopExists = true;
                Greenfoot.setWorld(new Shop());
            }
            else Greenfoot.setWorld(Shop.shop); //if player already went in the shop, then save the previous shop world
        }
        //Menu
        if(Greenfoot.mouseClicked(pausemenu))
        {
            Title.click.play();
            drawPauseMenu(); //Summons the pause menu screen
        }
        // On the Menu screen:
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
    
    // This method draws the pause menu
    public void drawPauseMenu(){
        removeObjects(getObjects(null)); //removes all buttons on GameHall
        
        // Pause menu screen buttons
        addObject(new Picture(new GreenfootImage("menuscreen.png")), 480, 270);
        addObject(resume, 480, 240);
        if(Title.bgm.isPlaying()) addObject(musicOnMenu, 480, 300);
        else addObject(musicOffMenu, 480, 300);
        addObject(backtotitle, 480, 360);
    }
    
    // This method checks whether the player presses resume, backtotitle, or backtoarcade
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

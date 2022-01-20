import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The GameHall contains all mini games, the menu, and the shop
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameHall extends World
{
    //Mini game buttons
    private Buttons memoryGame = new Buttons(new GreenfootImage("MemoryGame.png"));
    private Buttons rps = new Buttons(new GreenfootImage("RPS.png"));
    private Buttons jackpot = new Buttons(new GreenfootImage("jackpot.png"));
    private Buttons hangman = new Buttons(new GreenfootImage("Hangman.png"));
    
    // Menu, Achievements, Shop, Inventory buttons
    private Buttons pausemenu = new Buttons(new GreenfootImage("MenuButton.png"));
    private Buttons achievements = new Buttons(new GreenfootImage("AchievementsButton.png"));
    private Buttons shop = new Buttons(new GreenfootImage("ShopButton.png"));
    private Buttons inventory = new Buttons(new GreenfootImage("InventoryButton.png"));
    // Pause menu buttons
    public static Buttons resume = new Buttons(new GreenfootImage("resumebutton.png"));
    public static Buttons backToTitle = new Buttons(new GreenfootImage("BackToTitleButton.png"));
    public static Buttons backToArcade = new Buttons(new GreenfootImage("BackToArcadeButton.png"));
    public Buttons musicOnMenu = new Buttons(new GreenfootImage("Menu-MusicOnButton.png"));
    public Buttons musicOffMenu = new Buttons(new GreenfootImage("Menu-MusicOffButton.png"));
    
    // Amount of Golden Tickets the player has
    public static GoldenTickets currency = new GoldenTickets();
    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public GameHall()
    {    
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
        //show Golden Tickets
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
        //Achievements
        if(Greenfoot.mouseClicked(achievements))
        {
            Title.click.play();
            Greenfoot.setWorld(new Achievements());
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
        //Inventory
        if(Greenfoot.mouseClicked(inventory)){
            Title.click.play();
            Greenfoot.setWorld(new Inventory());
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
        addObject(new Picture(new GreenfootImage("MenuScreen.png")), 480, 270);
        addObject(resume, 480, 240);
        if(Title.bgm.isPlaying()) addObject(musicOnMenu, 480, 300);
        else addObject(musicOffMenu, 480, 300);
        addObject(backToTitle, 480, 360);
    }
    
    // This method checks whether the player presses resume, backtotitle, or backtoarcade
    public static void checkPause(){
        if(Greenfoot.mouseClicked(resume))
        {
            Title.click.play();
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(backToTitle))
        {
            Title.click.play();
            Greenfoot.setWorld(new Title());
        }
        if(Greenfoot.mouseClicked(backToArcade))
        {
            Title.click.play();
            Greenfoot.setWorld(new GameHall());
        }
    }
}

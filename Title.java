import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the title screen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    private Buttons playButton = new Buttons(new GreenfootImage("PlayButton.png"));
    private Buttons achievementsButton = new Buttons(new GreenfootImage("AchievementsButton.png"));
    private Buttons inventoryButton = new Buttons(new GreenfootImage("InventoryButton.png"));
    private Buttons exitButton = new Buttons(new GreenfootImage("ExitButton.png"));
    
    // Background music and sound effects
    public static GreenfootSound bgm = new GreenfootSound("Music.mp3");
    public static GreenfootSound cursor = new GreenfootSound("Cursor.mp3");
    public static GreenfootSound click = new GreenfootSound("Click.mp3");
    public static GreenfootSound winSound = new GreenfootSound("win-sound.mp3");
    public static GreenfootSound loseSound = new GreenfootSound("lose-sound.mp3");
    public static GreenfootSound cashSound = new GreenfootSound("cash-sound.mp3");
    private Buttons musicOn = new Buttons(new GreenfootImage("musicon.png"));
    private Buttons musicOff = new Buttons(new GreenfootImage("musicoff.png"));
    
    //Keep track of games that have been played
    //Order of games is Memory Game, RPS, Jackpot, HangMan
    public static boolean[] gamesPlayed = new boolean[4];
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        setBackground(new GreenfootImage("TitleScreen.png"));
        
        addObject(playButton, 480, 300);
        addObject(achievementsButton, 180, 400);
        addObject(inventoryButton, 480, 400);
        addObject(exitButton, 780, 400);
        
        addObject(musicOff, 930, 30);
        
        //No games played yet
        for(boolean played : gamesPlayed)
        {
            played = false;
        }
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(playButton)) {
            click.play();
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(achievementsButton)) {
            click.play(); 
            Greenfoot.setWorld(new Achievements());
        }
        if(Greenfoot.mouseClicked(inventoryButton)) {
            click.play(); 
            Greenfoot.setWorld(new Inventory());
        }
        if(Greenfoot.mouseClicked(exitButton)) {
            click.play();
            removeObjects(getObjects(null));
            setBackground(new GreenfootImage("ExitScreen.png"));
            bgm.pause();
            Greenfoot.stop();
        }
        
        if(Greenfoot.mouseClicked(musicOn)){
            bgm.pause();
            addObject(musicOff, 930, 30);
            removeObject(musicOn);
        }
        if(Greenfoot.mouseClicked(musicOff)){
            Title.bgm.playLoop();
            addObject(musicOn, 930, 30);
            removeObject(musicOff);
        }
    }
}

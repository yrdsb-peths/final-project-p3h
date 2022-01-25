import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the title screen that the player first sees.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    //Arcade and exit buttons
    private Buttons arcadeButton = new Buttons(new GreenfootImage("ArcadeButton-U.png"));
    private Buttons exitButton = new Buttons(new GreenfootImage("ExitButton-U.png"));
    
    // Background music and sound effects
    public static GreenfootSound bgm = new GreenfootSound("Music.mp3");
    public static GreenfootSound cursor = new GreenfootSound("Cursor.mp3");
    public static GreenfootSound click = new GreenfootSound("Click.mp3");
    public static GreenfootSound winSound = new GreenfootSound("win-sound.mp3");
    public static GreenfootSound loseSound = new GreenfootSound("lose-sound.mp3");
    public static GreenfootSound cashSound = new GreenfootSound("cash-sound.mp3");
    // Music On/Off buttons
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
        setBackground(new GreenfootImage("TitleWorld.png"));
        // Add arcade, exit, and music buttons
        addObject(arcadeButton, 332, 404);
        addObject(exitButton, 628, 404);
        addObject(musicOff, 930, 30);
        
        //No games played yet
        for(boolean played : gamesPlayed)
        {
            played = false;
        }
    }
    
    // Act() method is called when the player presses Run
    public void act()
    {
        if(Greenfoot.mouseClicked(arcadeButton)) {
            click.play();
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(exitButton)) {
            click.play();
            removeObjects(getObjects(null));
            setBackground(new GreenfootImage("ExitScreen.png"));
            bgm.pause();
            Greenfoot.stop();
        }
        // If player clicked on the music on/off switch
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

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
    //private Buttons musicOn = new Buttons(new GreenfootImage("SoundOn.png"), getHeight()/10, 1);
    //private Buttons musicOff = new Buttons(new GreenfootImage("SoundOff.png"), getHeight()/10, 1);
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
        
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(playButton)) {
            click.play();
            Greenfoot.setWorld(new GameHall());
        }
        if(Greenfoot.mouseClicked(achievementsButton)) {
            click.play(); 
            //Greenfoot.setWorld(new Achievements());
        }
        if(Greenfoot.mouseClicked(inventoryButton)) {
            click.play(); 
            Greenfoot.setWorld(new Inventory());
        }
        if(Greenfoot.mouseClicked(exitButton)) {
            click.play();
            //addObject(exitScreen, getWidth()/2+50, getHeight()/2+15);
            bgm.pause();
            Greenfoot.stop();
        }
    }
}

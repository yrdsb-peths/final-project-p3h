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
    private Buttons tictactoe = new Buttons(new GreenfootImage("tictactoebutton.png"));
    private Buttons trivia = new Buttons(new GreenfootImage("triviabutton.png"));
    
    // private Buttons pausemenu = new Buttons(new GreenfootImage("pausemenu.png"));
    // 
    /**
     * Constructor for objects of class GameHall.
     * 
     */
    public GameHall()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        //add games
        addObject(memoryCard, 280, 250);
        addObject(rockpaperscissors, 380, 250);
        addObject(jackpot, 480, 250);
        addObject(tictactoe, 580, 250);
        addObject(trivia, 680, 250);
    }
}

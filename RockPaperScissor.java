import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is the rock paper scissors game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockPaperScissor extends World
{
    private static final String USER_PLAYER = "User wins!";
    private static final String COMPUTER_PLAYER = "Computer wins!";
    private static final String TIE = "Tie";
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RockPaperScissor()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
    }
    private String getWinner(String user, String computer)
    {
        if(user.equals("rock"))
        {
            if(computer.equals("paper"))
            {
                return COMPUTER_PLAYER;
            }
            else if(computer.equals("scissors"))
            {
                return USER_PLAYER;
            }
        }
        else if(user.equals("paper") && computer.equals("scissors"))
        {
            return COMPUTER_PLAYER;
        }
        else if(user.equals("scissors") && computer.equals("paper"))
        {
            return USER_PLAYER;
        }
        else if(computer.equals("rock"))
        {
            if(user.equals("scissors"))
            {
                return COMPUTER_PLAYER;
            }
            return USER_PLAYER;
        }
        return TIE;
    }
  
}

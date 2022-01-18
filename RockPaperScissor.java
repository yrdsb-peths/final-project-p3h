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
    private Buttons rock = new Buttons(new GreenfootImage("rockButton.png"));
    private Buttons paper = new Buttons(new GreenfootImage("paperButton.png"));
    private Buttons scissors = new Buttons(new GreenfootImage("scissorsButton.png"));
    private Buttons computerRock = new Buttons(new GreenfootImage("computerRock.png"));
    private Buttons computerPaper = new Buttons(new GreenfootImage("computerPaper.png"));
    private Buttons computerScissors = new Buttons(new GreenfootImage("computerScissors.png"));
    
    private String playerWonRound = "You win this round!";
    private String computerWonRound = "You lost this round";
    private String playerTie = "It's a tie!";
    
    private Buttons winString = new Buttons(new GreenfootImage(playerWonRound, 40, Color.BLACK, new Color(0,0,0,0)));
    private Buttons loseString = new Buttons(new GreenfootImage(computerWonRound, 40, Color.BLACK, new Color(0,0,0,0)));
    private Buttons tieString = new Buttons(new GreenfootImage(playerTie, 40, Color.BLACK, new Color(0,0,0,0)));
    
    private String userInput = "";
    private String computerInput;
    
    private Counter playerWins = new Counter();
    private Counter computerWins = new Counter();
    
    private boolean ticketsAdded = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RockPaperScissor()
    {    
        super(960, 540, 1); 
        
        //Add Player interactive buttons
        addObject(rock, 280, 430);
        addObject(paper, 480, 430);
        addObject(scissors, 680, 430);
        //Add Golden tickets Counter
        addObject(GameHall.currency, 150, 520);
    }
    
    private String getComputerInput()
    {
        Random r = new Random();
        int n = r.nextInt(3);
        if(n == 0)
        {
            return "rock";
        }
        if(n == 1)
        {
            return "paper";
        }
        return "scissors";
    }
    
    private void getComputerImage(String str)
    {
        if(str.equals("rock")) addObject(computerRock, 490, 165);
        else if(str.equals("paper")) addObject(computerPaper,490, 165);
        else if(str.equals("scissors")) addObject(computerScissors, 490, 165);
    }
    
    private void removeCompImg()
    {
        removeObject(computerRock);
        removeObject(computerPaper);
        removeObject(computerScissors);
    }
    
    private String getWinner(String user, String computer)
    {
        if(user.equals("rock"))
        {
            if(computer.equals("paper"))
            {
                return computerWonRound;
            }
            else if(computer.equals("scissors"))
            {
                return playerWonRound;
            }
        }
        else if(user.equals("paper") && computer.equals("scissors"))
        {
            return computerWonRound;
        }
        else if(user.equals("scissors") && computer.equals("paper"))
        {
            return playerWonRound;
        }
        else if(computer.equals("rock"))
        {
            if(user.equals("scissors"))
            {
                return computerWonRound;
            }
            return playerWonRound;
        }
        return playerTie;
    }
    
    private void checkWin(String str)
    {
        if(str.equals(playerWonRound))
        {
            playerWins.add();
            getComputerImage(computerInput);
            addObject(winString, 480, 270);
            Greenfoot.delay(40);
            removeObject(winString);
            removeCompImg();
        }
        else if(str.equals(computerWonRound))
        {
            computerWins.add();
            getComputerImage(computerInput);
            addObject(loseString, 480, 270);
            Greenfoot.delay(40);
            removeObject(loseString);
            removeCompImg();
        }
        else if(str.equals(playerTie))
        {
            getComputerImage(computerInput);
            addObject(tieString, 480, 270);
            Greenfoot.delay(40);
            removeObject(tieString);
            removeCompImg();
        }
    }
    
    private boolean checkGameEnd()
    {
        if(playerWins.getScore() >= 5 || computerWins.getScore() >= 5) return true;
        return false;
    }
    
    private void gameEndScreen()
    {
        if(playerWins.getScore() >= 5)
        {
            setBackground(new GreenfootImage("rps-WinScreen.png"));
            if(!ticketsAdded)
            {
                GoldenTickets.addTickets(20);
            }
            
            ticketsAdded = true;
        }
        else
        {
            setBackground(new GreenfootImage("rps-LoseScreen.png")); 
            if(!ticketsAdded)
            {
                GoldenTickets.addTickets(-10);
            }
            
            ticketsAdded = true;
        }
        //remove player interactive buttons
        removeObject(rock);
        removeObject(paper);
        removeObject(scissors);
        
        //Set game as played
        Title.gamesPlayed[1] = true;
    }
    
    public void act()
    {
        //Add player and computer score counter
        addObject(playerWins, 200, 300);
        addObject(computerWins, 760, 300);
        
        // Random computer rock/paper/scissors
        computerInput = getComputerInput();
        
        if(Greenfoot.mouseClicked(rock))
        {
            userInput = "rock";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
        else if(Greenfoot.mouseClicked(paper))
        {
            userInput = "paper";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
        else if(Greenfoot.mouseClicked(scissors))
        {
            userInput = "scissors";
            String str = getWinner(userInput, computerInput);
            checkWin(str);
        }
    
        userInput = "";
        computerInput = "";
        
        //Check if player or computer hits 5 points first, then pop out game end screen
        if(checkGameEnd())
        {
            //Add back to title button
            addObject(GameHall.backtoarcade, 495, 390);
            gameEndScreen();
            GameHall.checkPause();
        }
    }
}

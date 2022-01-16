import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class HangMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangMan extends World
{
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private String word;
    
    private Letter[] letters = new Letter[26];
    private int correct;
    private int wrong;
    
    private boolean gameOver;
    /**
     * Constructor for objects of class HangMan.
     * 
     */
    public HangMan()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        
        //Add words to ArrayList
        try{
            Reader.readInto(listOfWords);
        } 
        catch(Exception e) {
        }
        
        //Add letters
        for(int i=0; i<26; i++) 
        {
            addObject(letters[i] = new Letter(i), 250 + 38*(i%13), 410 + 30*(i/13));
        }
        
        //Get random word and add the underlines
        Random r = new Random();
        word = listOfWords.get(r.nextInt(listOfWords.size()));
        int firstX = getWidth()/2 - word.length() * 10 - 30; // x-coordinate of the first underline
        for(int i=0; i<word.length(); i++)
        {
            Buttons underline = new Buttons(new GreenfootImage("_", 42, Color.BLACK, new Color(0,0,0,0)));
            addObject(underline, firstX + 36 * i, getHeight() - 50);
        }
        
        //Add Golden tickets Counter
        addObject(GameHall.currency, 150, 500);
    }
    
    // Player interacts with game by clicking on buttons in the act method
    public void act()
    {
        // Detect if player choosed a letter using mouse
        if(Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse == null) return;
            Actor actor = mouse.getActor();
            if(actor != null && actor instanceof Letter) letterCheckClick((Letter)actor);
        }
        
        GameHall.checkPause();
    }
    
    private void letterCheckKey(String key)
    {
        letterCheckClick(letters[(int)key.charAt(0)-65]);
    }
    
    private void letterCheckClick(Letter theLetter)
    {
        //check if player choosed new letter or one that was already picked
        if(theLetter.wasPicked()) return;
        theLetter.pickImage();
        
        // Find if the letter exists in the word
        char letter = theLetter.letter.charAt(0);
        boolean inWord = false;
        for(int i=0; i<word.length(); i++)
        {
            if(Character.toLowerCase(letter) == word.charAt(i))
            {
                showLetter(i, Color.BLACK);
                Greenfoot.delay(1);
                inWord = true;
                correct++;
                if(correct == word.length())
                {
                    gameOver = true;
                    for(int j=0; j<26; j++)
                    {
                        removeObject(letters[j]);
                    }
                    GoldenTickets.addTickets(20);
                    Buttons winScreen = new Buttons(new GreenfootImage("hangman-winScreen.png"));
                    addObject(winScreen, 800, 150);
                    addObject(GameHall.backtoarcade, 810, 300);
                }
            }
        }
        if(!inWord)
        {
            wrong++;
            switch(wrong)
            {
                case 1:
                    setBackground(new GreenfootImage("hangman-1.png"));
                    break;
                case 2:
                    setBackground(new GreenfootImage("hangman-2.png"));
                    break;
                case 3:
                    setBackground(new GreenfootImage("hangman-3.png"));
                    break;
                case 4:
                    setBackground(new GreenfootImage("hangman-4.png"));
                    break;
                case 5:
                    setBackground(new GreenfootImage("hangman-5.png"));
                    break;
                case 6: 
                    setBackground(new GreenfootImage("hangman-6.png"));
                    gameOver = true;
                    for(int i=0; i<26; i++)
                    {
                        removeObject(letters[i]);
                    }
                    
                    for(int i=0; i<word.length(); i++)
                    {
                        showLetter(i, Color.RED);
                    } 
                    addObject(GameHall.backtotitle, 810, 300);
                    break;
            }
        }
    }
    
    private void showLetter(int index, Color color)
    {
        String letter = word.substring(index, index+1);
        Actor actor = getGenericActor();
        actor.setImage(getLetterImage(letter, color));
        int firstX = getWidth()/2 - word.length()*10 - 30;
        addObject(actor, firstX + 36*index, getHeight()-45);
    }
    
    private GreenfootImage getLetterImage(String letter, Color color)
    {
        return new GreenfootImage(letter, 42, color, new Color(0,0,0,0));
    }
    
    private Actor getGenericActor()
    {
        return new Actor(){};
    }
}

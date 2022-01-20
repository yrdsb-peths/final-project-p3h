import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the Hangman mini game. The player wins if they guessed
 * all the correct letters in a random word.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangMan extends World
{
    //Initialize the list of words to choose from and the word chosen
    private ArrayList<String> listOfWords = new ArrayList<String>();
    private String word;
    
    //All 26 letters of the alphabet
    private Letter[] letters = new Letter[26];
    // Number of letters the player guessed correctly vs. wrongly
    private int correct;
    private int wrong;
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
        
        //Add letters to world
        for(int i=0; i<26; i++) 
        {
            addObject(letters[i] = new Letter(i), 250 + 38*(i%13), 410 + 30*(i/13));
        }
        
        //Get a random word and add the underlines for the word
        Random r = new Random();
        word = listOfWords.get(r.nextInt(listOfWords.size()));
        int firstX = getWidth()/2 - word.length() * 10 - 30; // x-coordinate of the first underline
        for(int i=0; i<word.length(); i++)
        {
            Picture underline = new Picture(new GreenfootImage("_", 42, Color.BLACK, new Color(0,0,0,0)));
            addObject(underline, firstX + 36 * i, 490);
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
            if(actor != null && actor instanceof Letter)letterCheckClick((Letter)actor);
        }
        
        // Check if player clicked on backtoarcade after finishing the game
        GameHall.checkPause();
    }
    
    // This method checks if the letter: 1. Was picked or not 2. In the word or not
    // 3. Was the last letter of the word or the last guess
    private void letterCheckClick(Letter theLetter)
    {
        //check if the player choosed new letter or not
        if(theLetter.wasPicked()) return;
        theLetter.pickImage();
        
        // Find if the letter exists in the word
        char letter = theLetter.letter.charAt(0);
        boolean inWord = false;
        for(int i=0; i<word.length(); i++)
        {
            if(Character.toLowerCase(letter) == word.charAt(i)) //found letter
            {
                Title.winSound.play();
                showLetter(i, Color.BLACK); // shows letter on underline
                Greenfoot.delay(1); // time to show the letter appearing
                inWord = true; // letter exists in the word
                correct++; // number of correct letters
                if(correct == word.length()) // finished all letters in the word
                {
                    for(int j=0; j<26; j++) // remove 26 letters
                    {
                        removeObject(letters[j]); 
                    }
                    GoldenTickets.addTickets(20); // Player earns 20 tickets
                    //Set win screen
                    Picture winScreen = new Picture(new GreenfootImage("hangman-winScreen.png"));
                    addObject(winScreen, 800, 150);
                    addObject(GameHall.backToArcade, 810, 300);
                    //Set game as played
                    Title.gamesPlayed[3] = true;
                }
            }
        }
        if(!inWord) //letter does not exist in word
        {
            Title.loseSound.play();
            wrong++; // Number of wrong guesses
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
                case 6: // If the player guessed the wrong letter 6 times, they lose
                    setBackground(new GreenfootImage("hangman-6.png"));
                    for(int i=0; i<26; i++) // remove 26 letters
                    {
                        removeObject(letters[i]);
                    }
                    for(int i=0; i<word.length(); i++) // shows the correct word
                    {
                        showLetter(i, Color.RED);
                    } 
                    addObject(GameHall.backToArcade, 810, 300);
                    
                    //Set game as played
                    Title.gamesPlayed[3] = true;
                    break;
            }
        }
    }
    
    // This method shows the letters in the word onto the underlines
    private void showLetter(int index, Color color)
    {
        String letter = word.substring(index, index+1);
        Picture pic = new Picture((getLetterImage(letter, color)));
        int firstX = getWidth()/2 - word.length()*10 - 30;
        addObject(pic, firstX + 36*index, getHeight()-45);
    }
    
    // This method returns the GreenfootImage of the letter that would be shown on the underlines
    private GreenfootImage getLetterImage(String letter, Color color)
    {
        return new GreenfootImage(letter, 42, color, new Color(0,0,0,0));
    }
}

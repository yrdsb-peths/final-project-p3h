import greenfoot.*;

/**
 * This class is the memory card game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MemoryGame extends World
{
    private static final int ROWS=4, COLUMNS=4;
    private static final int imageSize = 100; //height and width of the images in the Card class
    
    // Initialize memory cards
    private Card[] cards = new Card[ROWS*COLUMNS]; //all 16 cards
    private Card[] activeCards = new Card[2]; // two cards the player picked
    // Initialize timer
    private int timer = 0; //show images while timer>0
    private int pauseTime = 50; //number of time the player can memorize the cards
    public static SimpleTimer timeSec = new SimpleTimer(); //timer to count amount of seconds
    
    private Color yellow = new Color(255, 222, 89); // color for win String
    
    public static boolean timeBelow30 = false; // boolean for timer
    public MemoryGame()
    {    
        super(960, 540, 1);
        
        //create an array of nums (1,1,2,2,3,3,...)
        int[] num = new int[ROWS*COLUMNS];
        for (int i=0; i<num.length; i++)
        {
            num[i] = 1 + i/2;
        }
        
        //shuffle the array randomly
        for (int i=0; i<num.length; i++)
        {
            int random = i + Greenfoot.getRandomNumber(num.length - i);
            int n = num[i];
            num[i] = num[random];
            num[random] = n;
        }
        
        //Add the cards to the world
        for (int x=0; x<COLUMNS; x++) for (int y=0; y<ROWS; y++)
        {
            addObject(cards[x * ROWS + y] = new Card(num[x * ROWS + y]), imageSize + x * (imageSize*4/3) - 25, imageSize + y * (imageSize*4/3) - 30);
        }
        
        //Add Golden tickets Counter
        addObject(GameHall.currency, 820, 500);
        
        timeSec.mark(); // start timer
    }
    
    public void act()
    {
        if (timer>0) //if two different cards were recently discovered
        {
            if (--timer==0) //timer ends
            {
                //turn them upside down again
                for (int i=0; i<2; i++)
                {
                    activeCards[i].updateImage(false);
                    activeCards[i] = null;
                }
            }
            return; 
        }
        
        // Checks when player chooses cards to match
        for (Card card : cards)
        {
            if (!card.getSolved() && activeCards[0] != card && Greenfoot.mouseClicked(card))
            {
                card.updateImage(true); //show card
                if (activeCards[0] == null) //first card
                {
                    activeCards[0] = card;
                }
                else //second card
                {
                    if (activeCards[0].getNum() == card.getNum()) //found pair
                    {
                        activeCards[0].setSolved(true);
                        activeCards[0] = null;
                        card.setSolved(true);
                        
                        //check if this was the last pair
                        boolean allSolved = true;
                        for (Card c : cards) //check if all cards were solved
                        {
                            if (!c.getSolved()) //card not solved yet
                            {
                                allSolved = false;
                                break; //found one, no need to check the others
                            }
                        }
                        if (allSolved)
                        {
                            // Win screen
                            addObject(GameHall.backToArcade, 750, 450);
                            Title.winSound.play();
                            addObject(new Picture(new GreenfootImage("Great job! You finished in " + timeSec.millisElapsed()/1000 + " seconds"
                            ,26, yellow, new Color(0,0,0,0))), 750, 400);
                            GoldenTickets.addTickets(20);
                            
                            //Check if time is below 30 seconds
                            if(timeSec.millisElapsed()/1000 <= 30)
                            {
                                timeBelow30 = true;
                            }
                            
                            //Set this game as played
                            Title.gamesPlayed[0] = true;
                        }
                    }
                    else //different cards
                    {
                        activeCards[1] = card;
                        timer = pauseTime;
                    }
                }
                //no need to check for other cards because you can't press two together at the same time
                return;
            }
        }
        
        GameHall.checkPause(); // check if player pressed on backtoarcade
    }
}

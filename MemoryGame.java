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
    
    private Card[] cards = new Card[ROWS*COLUMNS]; //all 16 cards
    private Card[] activeCards = new Card[2];
    private int timer = 0; //show images while timer>0
    private int pauseTime = 50; //number of time the player can memorize the cards
    
    public MemoryGame()
    {    
        super(960, 540, 1);
        
        //create an array of nums (1,1,2,2,3,3, ...)
        int[] num = new int[ROWS*COLUMNS];
        for (int i=0; i<num.length; i++)
        {
            num[i] = 1 + i/2;
        }
        
        //shuffle the array randomly
        for (int i=0; i<num.length; i++)
        {
            int random = i + Greenfoot.getRandomNumber(num.length - i);
            int help = num[i];
            num[i] = num[random];
            num[random] = help;
        }
        
        //add the cards to the world
        for (int x=0; x<COLUMNS; x++) for (int y=0; y<ROWS; y++)
        {
            addObject(cards[x * ROWS + y] = new Card(num[x * ROWS + y]), imageSize + x * (imageSize*4/3) - 25, imageSize + y * (imageSize*4/3) - 30);
        }
        
        //Add Golden tickets Counter
        addObject(GameHall.currency, 820, 500);
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
        
        for (Card card : cards) //for each Card
        {
            if (!card.getSolved() && activeCards[0] != card && Greenfoot.mousePressed(card))
            {
                card.updateImage(true); ////show card
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
                        for (Card c : cards)
                        {
                            if (!c.getSolved()) //card not solved yet
                            {
                                allSolved = false;
                                break; //found one, no need to check the others
                            }
                        }
                        if (allSolved)
                        {
                            //add back to title button
                            addObject(GameHall.backtotitle, 750, 500);
                            GoldenTickets.addTickets(20);
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
        
        GameHall.checkPause();
    }
}

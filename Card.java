import greenfoot.*;
public class Card extends Actor
{
    private static final GreenfootImage[] images =
    {
        new GreenfootImage("0.png"), //image file of the cardback (when card is not active)
        //list all possible different cards -- total number (excluding cardback) has to match the product of ROWS and COLUMNS in MyWorld
        new GreenfootImage("1.png"),
        new GreenfootImage("2.png"),
        new GreenfootImage("3.png"),
        new GreenfootImage("4.png"),
        new GreenfootImage("5.png"),
        new GreenfootImage("6.png"),
        new GreenfootImage("7.png"),
        new GreenfootImage("8.png"),
    };
    private final int ID; //same number represents a pair
    private boolean solved = false; //found pair already?
    public Card(int ID)
    {
        this.ID = ID;
        updateImage(false);
    }
    
    public void updateImage(boolean showCard)
    {
        setImage(images[showCard ? ID : 0]);
    }
    
    public int getID() {return ID;}
    
    public void setSolved(boolean solved) {this.solved = solved;}
    public boolean getSolved() {return solved;}
    
    public static int getNumberOfIDs() {return images.length-1;}
}

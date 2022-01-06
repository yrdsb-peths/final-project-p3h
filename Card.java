import greenfoot.*;
public class Card extends Actor
{
    private static final GreenfootImage[] images =
    {
        new GreenfootImage("0.png"), 
        new GreenfootImage("1.png"),
        new GreenfootImage("2.png"),
        new GreenfootImage("3.png"),
        new GreenfootImage("4.png"),
        new GreenfootImage("5.png"),
        new GreenfootImage("6.png"),
        new GreenfootImage("7.png"),
        new GreenfootImage("8.png"),
    };
    private final int num; //same number represents a pair
    private boolean solved = false; //found pair or not
    public Card(int num)
    {
        this.num = num;
        updateImage(false);
    }
    
    public int getNum() 
    {
        return num;
    }
    
    public void setSolved(boolean solved) 
    {
        this.solved = solved;
    }
    public boolean getSolved() {
        return solved;
    }
    
    public void updateImage(boolean showCard)
    {
        setImage(images[showCard ? num : 0]);
    }
    
    public static int getNumberOfIDs() {
        return images.length-1;
    }
}

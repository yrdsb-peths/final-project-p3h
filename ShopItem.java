import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create an item in the shop w/ its price
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopItem extends Actor
{
    private GreenfootImage board = new GreenfootImage(192, 225);
    private Color yellow = new Color(255, 186, 8);
    private Font fnt = new Font(true, false, 30);
    
    public GreenfootImage img; // See Buttons class for descriptions of these variables
    public int price;
    public boolean ifMoved = false;
    public boolean firstMove = true;
    public ShopItem(GreenfootImage img, int price)
    {
        this.img = img;
        this.price = price;
        drawBorder(yellow);
    }
    
    private void drawBorder(Color color)
    {
        board.setColor(color);
        board.fill();
        board.setColor(Color.WHITE);
        board.fillRect(5, 5, 182, 182);
        setImage(board);
        img.scale(182, 182 * img.getHeight() / img.getWidth());
        board.drawImage(img, 5, 5);
        board.setColor(Color.BLACK);
        board.setFont(fnt);
        board.drawString(String.valueOf(price), 80, 218);
    }
    
    public void soldOut()
    {
        setImage(new GreenfootImage("SoldOut.png"));
    }
    
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            if(firstMove){
                firstMove = false;
                ifMoved = true;
                Title.cursor.play();
                drawBorder(yellow.brighter());
            }
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            firstMove = true;
            if(ifMoved){
                ifMoved = false;
                drawBorder(yellow);
            }
        }
    }
}

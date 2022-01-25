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
    public int price; //price of the shop item
    public boolean bought = false; // checks if the shop item is bought or not
    public boolean ifMoved = false;
    public boolean firstMove = true;
    public ShopItem(GreenfootImage img, int price)
    {
        this.img = img;
        this.price = price;
        if(!bought) drawBorder(yellow);
    }
    // Draws the border of the shop item
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
    
    // If the player bought this shop item, the shop item is replaced with a "sold out" sign
    public void soldOut()
    {
        img = new GreenfootImage("SoldOut.png");
        setImage(img);
        bought = true;
    }
    
    // When the mouse hovers over a shop item, the border turns brighter yellow
    public void act()
    {   if(!bought)
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
}

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
    
    public ShopItem(GreenfootImage img, int price)
    {
        board.setColor(yellow);
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
}

package comp.DITU.Game.Sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Sprite {
	public int speed,speedx;
	public int x;
	public int y;
	public int w;
	public int h;
	public ImageIcon image;
	public BufferedImage HeartImage;
	
	public void draw(Graphics pen)
	{
		pen.drawImage(image.getImage(),x,y,w,h, null);
	} 
	
}

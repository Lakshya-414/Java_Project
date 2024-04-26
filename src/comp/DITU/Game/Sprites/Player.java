package comp.DITU.Game.Sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite
{
	
	public Player()
	{
		w=200;
		h=150;
		x=5;
		y=700;
		image=new ImageIcon(Player.class.getResource("FighterJet.gif"));
		
	}
	public void move()
	{
		y=y+speed;
		x=x+speedx;
	}
	public boolean outOfScreen()
	{
		return y<0;
	}
	
}

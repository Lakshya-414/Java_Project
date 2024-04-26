package comp.DITU.Game.Sprites;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Heart extends Sprite
{
	public Heart()
	{
		w=75;
		h=75;
		y=0;
		x=1400;
		image=new ImageIcon(Player.class.getResource("Heart.gif"));
		
	}
	
	
} 

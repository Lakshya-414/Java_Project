package comp.DITU.Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import comp.DITU.Game.Sprites.Enemy;
import comp.DITU.Game.Sprites.Heart;
import comp.DITU.Game.Sprites.Player;

public class Board extends JPanel
{
	Timer timer;
	ImageIcon backgroundImage;
	Player player;
	Enemy enemies[]=new Enemy[5];
	Heart heart;

	public Board()
	{
		setSize(1595,980);
		GameLoop();
		loadBackgroundImage();
		player=new Player();
		heart=new Heart();
		loadEnemies();
		bindEvents();
		setFocusable(true);
		
		
	}

	private void bindEvents()
	{
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
				player.speed=-5;
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					player.speed=5;
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					player.speedx=-5;
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					player.speedx=5;
				}
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				player.speed=0;
				player.speedx=0;
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	private boolean HeartCollect(Heart heart)
	{
		int xDistance=Math.abs(player.x-heart.x);
		int yDistance=Math.abs(player.y-heart.y);
		int maxH=Math.max(player.h, heart.h);
		int maxW=Math.max(player.w, heart.w);
		return xDistance<=maxW-110&&yDistance<=maxH-10;
	}
	private void gameOver(Graphics pen)
	{
		if(HeartCollect(heart))
		{
			pen.setFont(new Font("times",Font.HANGING_BASELINE,70));
			pen.setColor(Color.GREEN);
			pen.drawString("WINNER", 1200/2, 980/2);
			timer.stop();
			return;
		}
		for(Enemy enemy:enemies)
		{
			if(isCollide(enemy))
			{
				pen.setFont(new Font("times",Font.HANGING_BASELINE,70));
				pen.setColor(Color.RED);
				pen.drawString("GAME OVER", 1200/2, 980/2);
				timer.stop();
			}
		}
	}
	private boolean isCollide(Enemy enemy)
	{
		int xDistance=Math.abs(player.x-enemy.x);
		int yDistance=Math.abs(player.y-enemy.y);
		int maxH=Math.max(player.h, enemy.h);
		int maxW=Math.max(player.w, enemy.w);
		return xDistance<=maxW-105&&yDistance<=maxH-105;
	}
	private void loadEnemies() {
		int x=100;
		int gap=320;
		int speed=3;
		
		for(int i=0;i<enemies.length;i++)
		{
			enemies[i]=new Enemy(x,speed);
			x=x+gap;
			speed=speed+2;
		}
	}
	private void GameLoop()
	{
		timer=new Timer(10,(e)->repaint());
		
		timer.start();
	}
	private void loadBackgroundImage()
	{
		backgroundImage=new ImageIcon(Board.class.getResource("background.gif"));
		if (backgroundImage == null) {
	        System.out.println("Image not found");
	        System.exit(1);
	    }
	}
		private void printEnemies(Graphics pen)
	{
		for(Enemy enemy:enemies)
		{
			enemy.draw(pen);
			enemy.move();
		}
	}
		
	@Override
	public void paintComponent(Graphics pen)
	{
		super.paintComponent(pen);//cleanup
		//All printing logic
		pen.drawImage(backgroundImage.getImage(),-50,0,1595,980,null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
		heart.draw(pen);
		
	}
}

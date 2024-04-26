package comp.DITU.Game;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame()//Constructor
	{
		Board board=new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Air Battle");
		setResizable(false);
		setSize(1700,980);
		setLocationRelativeTo(null);
		add(board);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame();//object created
		
	}

}

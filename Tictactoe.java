package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Tictactoe implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame("Tic-Tac-Toe Game");
	JPanel panel_title = new JPanel();
	JPanel panel_button = new JPanel();
	JLabel textField = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;
	int flag=0;
	int i;

	Tictactoe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color	(126,75,139));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(126,75,139));
		textField.setForeground(new Color(251,241,249));
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		
		
		
		
		
		panel_title.setLayout(new BorderLayout());
		panel_title.setBounds(0,0,800,100);
		
		panel_button.setLayout(new GridLayout(3,3));
		panel_title.setBackground(new Color(251,241,249));
		
		
		
		for(int i=0;i<9;i++)
		{
			button[i]=new JButton();
			panel_button.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,128));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
			button[i].setBackground(new Color(251,241,249));
		}
		
		panel_title.add(textField);	
		frame.add(panel_title,BorderLayout.NORTH);
		frame.add(panel_button);
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(i =0;i<9;i++) {
		if(e.getSource()==button[i]) {
		if(player1_turn) {
		if(button[i].getText()=="")
		{
			button[i].setForeground(new Color(41, 7, 34));
			button[i].setText("X");
			player1_turn=false;
			textField.setText("O Turn");
			flag++;
			check();
		}
		}
		else
		{
			if(button[i].getText()=="")
			{
			button[i].setForeground(new Color(97, 20, 82));
			button[i].setText("O");
			player1_turn=true;
			textField.setText("X Turn");
			flag++;
			check();
			}
		}
		
	}
	}
	}
	
	public void firstTurn()
	{
			try {
				textField.setText("Loading..");
				Thread.sleep(3000);
				
							
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(random.nextInt(2)==0)
			{
				
				 player1_turn = true;
				 textField.setText("X Turn");
			}
			else
			{
				
				 player1_turn = false;
				 textField.setText("O Turn");
			}
		
		
	}
	
	public void gameOver(String s)
    {
        flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog
        		(frame, 
        		"Game Over\n"+s,"Game Over", 
        		JOptionPane.YES_NO_CANCEL_OPTION, 
        		JOptionPane.QUESTION_MESSAGE, 
        		null, option, option[0]);
        if(n==0)
        {
            frame.dispose();
            new Tictactoe();
        }
        else
        {
            frame.dispose();
        }
    
    }

	
	public void check()
	{
		if(
				button[0].getText()=="X" &&
				button[1].getText()=="X" &&
				button[2].getText()=="X"
				)
		{
			xWins(0,1,2);
		}
		
		if(
				button[3].getText()=="X" &&
				button[4].getText()=="X" &&
				button[5].getText()=="X"
				)
		{
			xWins(3,4,5);
		}
		
		if(
				button[6].getText()=="X" &&
				button[7].getText()=="X" &&
				button[8].getText()=="X"
				)
		{
			xWins(6,7,8);
		}
		
		if(
				button[0].getText()=="X" &&
				button[3].getText()=="X" &&
				button[6].getText()=="X"
				)
		{
			xWins(0,3,6);
		}
		
		if(
				button[1].getText()=="X" &&
				button[4].getText()=="X" &&
				button[7].getText()=="X"
				)
		{
			xWins(1,4,7);
		}
		
		if(
				button[2].getText()=="X" &&
				button[5].getText()=="X" &&
				button[8].getText()=="X"
				)
		{
			xWins(2,5,8);
		}
		
		if(
				button[0].getText()=="X" &&
				button[4].getText()=="X" &&
				button[8].getText()=="X"
				)
		{
			xWins(0,4,8);
		}
		
		if(
				button[2].getText()=="X" &&
				button[4].getText()=="X" &&
				button[6].getText()=="X"
				)
		{
			xWins(2,4,6);
		}
		
		//ywins
		
		if(
				button[0].getText()=="O" &&
				button[1].getText()=="O" &&
				button[2].getText()=="O"
				)
		{
			oWins(0,1,2);
		}
		
		if(
				button[3].getText()=="O" &&
				button[4].getText()=="O" &&
				button[5].getText()=="O"
				)
		{
			oWins(3,4,5);
		}
		
		if(
				button[6].getText()=="O" &&
				button[7].getText()=="O" &&
				button[8].getText()=="O"
				)
		{
			oWins(6,7,8);
		}
		
		if(
				button[0].getText()=="O" &&
				button[3].getText()=="O" &&
				button[6].getText()=="O"
				)
		{
			oWins(0,3,6);
		}
		
		if(
				button[1].getText()=="O" &&
				button[4].getText()=="O" &&
				button[7].getText()=="O"
				)
		{
			oWins(1,4,7);
		}
		
		if(
				button[2].getText()=="O" &&
				button[5].getText()=="O" &&
				button[8].getText()=="O"
				)
		{
			oWins(2,5,8);
		}
		
		if(
				button[0].getText()=="O" &&
				button[4].getText()=="O" &&
				button[8].getText()=="O"
				)
		{
			oWins(0,4,8);
		}
		
		if(
				button[2].getText()=="O" &&
				button[4].getText()=="O" &&
				button[6].getText()=="O"
				)
		{
			oWins(2,4,6);
		}
		
		if(flag==9)
		{
			textField.setText("Game Draw!!");
			gameOver("Game Draw!");
		}
		
		
		
		
	}
	
	public void xWins(int a,int b,int c)
	{
		button[a].setBackground(new Color(199, 167, 192));
		button[b].setBackground(new Color(199, 167, 192));
		button[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
			
		}
		textField.setText("X Wins");
		 gameOver("Player X Wins");
	}

	public void oWins(int a,int b,int c)
	{
		button[a].setBackground(new Color(199, 167, 192));
		button[b].setBackground(new Color(199, 167, 192));
		button[c].setBackground(new Color(199, 167, 192));
		
		for(int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
			
		}
		textField.setText("O Wins");
		gameOver("Player O Wins");
	}
}


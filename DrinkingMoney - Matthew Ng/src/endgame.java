/*
 * 
 * 
 * Last Class in the game, will tell player if they win or lose
 * 
 * 
 */

import java.awt.*;

import javax.swing.*;

public class endgame extends JFrame{
	// initiallize JLabels
	JLabel gameover = new JLabel("Game Over");
	JLabel win = new JLabel("You have over 40! you win!");
	JLabel lose = new JLabel("You didn't make over 40! you lose!");
	public endgame(){
		setLayout(null);
		setSize(500,500);
		setVisible(true);
		// JPanels are set to invisible by default, but will become visible depending if they win or lose
		win.setVisible(false);
		lose.setVisible(true);
		getContentPane().setBackground(DrinkingMoney.babyblue);		

		//Use JLabel to show the profit and if the game is won or lost
		
		// Winning number is over $40, if you have over $40, you win
		if(DrinkingMoney.Money >40) {
			win.setBounds(150,200, 200,100);
			// win message is visible
			win.setVisible(true);
			add(win);
		}
		// if you dont have over $40 you lose
		else if (DrinkingMoney.Money <= 40) {
			lose.setBounds(150,200, 200,100);
			// lose message is visible
			lose.setVisible(true);
			add(lose);
		}

	}


}

/*
 * Gives Player instructions to play the game
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions  extends JFrame implements ActionListener{

	//Setting JLabels to be able to show text for the instructions of the screen

	JLabel Header = new JLabel("Instructions");
	// Various JLabels are used for give spaced linebreaks
	JLabel Instructions = new JLabel("Welcome to Drinking Money! In this game you will be running a beverage stand with");
	JLabel Instructionc = new JLabel("two different sorts of beverages! ");
	JLabel Instructions2 = new JLabel("First, you will be given a shop where you can purchase various ingredients to make coffee and lemonade");
	JLabel Instructions3 = new JLabel("Then, you will be able to customize your drinks to sell, make sure to get the perfect ratio to get the most sales!!!!");
	JLabel Instructions4 = new JLabel("After, Select your desired location, pick based on the beverage that will sell best! Hint hint, adults like coffee");
	JLabel Instructions5 = new JLabel("You will be given 7 or 14 days to make your money, MAKE IT COUNT!");
	JLabel goodluck = new JLabel("GOOD LUCK!!!!!!");
	JButton Next = new JButton("Start!");

	public Instructions() {
		// constructor class
		setLayout(null);
		setSize(1000,700);
		setVisible(true);
		getContentPane().setBackground(DrinkingMoney.babyblue);		

		// Next Button Bounds
		Next.setBounds(700, 500, 200,100);
		Next.addActionListener(this);
		add(Next);

		// Intiating various fonts for JLabels
		Font headerFont = new Font("Arial", Font.PLAIN, 18);
		Font titleFont = new Font("Arial", Font.PLAIN, 30);
		Font Luck = new Font("Arial", Font.PLAIN, 50);


		// Setting the bounds of various JLabels for information around the JFrame
		Header.setBounds(80, 0, 450,100);
		Header.setFont(titleFont);
		add(Header);

		// Instruction JLabels are placed
		Instructions.setBounds(10, 50, 900, 150);
		Instructions.setFont(headerFont);
		add(Instructions);
		Instructionc.setBounds(10, 100, 900, 150);
		Instructionc.setFont(headerFont);
		add(Instructionc);
		Instructions2.setBounds(10, 150, 900, 150);
		Instructions2.setFont(headerFont);
		add(Instructions2);
		Instructions3.setBounds(10, 200, 900, 150);
		Instructions3.setFont(headerFont);
		add(Instructions3);
		Instructions4.setBounds(10, 250, 900, 150);
		Instructions4.setFont(headerFont);
		add(Instructions4);
		Instructions5.setBounds(10, 300, 900, 150);
		Instructions5.setFont(headerFont);
		add(Instructions5);
		goodluck.setBounds(10, 300, 900, 450);
		goodluck.setFont(Luck);
		add(goodluck);


	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Button that goes to the ingredients shop
		if (event.getSource() == Next) {
			this.setVisible(false);
			new IngredientsShop();

		}
	}

}

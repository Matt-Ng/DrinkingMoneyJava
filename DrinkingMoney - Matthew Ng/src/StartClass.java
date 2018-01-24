/*
 * Starting Page for the game
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Color;
import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;
public class StartClass extends JFrame implements ActionListener {

	// adding photos to the start screen, also some JLabels and buttons
	JLabel dollarsign = new JLabel(new ImageIcon("images/dollarsymbol.png"));
	JLabel lemonade = new JLabel(new ImageIcon("images/lemonade.png"));
	JLabel coffee = new JLabel(new ImageIcon("images/coffee.png"));
	JLabel WHICHONE = new JLabel("WHICH/ONE");
	JButton Days7 = new JButton("7 Days");
	JButton Days14 = new JButton("14 Days");
	JLabel title = new JLabel("Drinking Money");

	public StartClass(){
		setVisible(true);
		setSize(1000,700);
		setLayout(null);
		// new font for JLabels
		Font titleFont = new Font("Arial", Font.PLAIN, 30);
		getContentPane().setBackground(DrinkingMoney.babyblue);		
		add(title);

		// setting bounds for each photo
		dollarsign.setBounds(15, 105, 500, 500);
		add(dollarsign);

		lemonade.setBounds(675, 25, 300, 300);
		add(lemonade);

		coffee.setBounds(550, 125, 300, 300);
		add(coffee);

		//JLabel bounds set
		WHICHONE.setBounds(520, 410, 200,150);
		WHICHONE.setFont(titleFont);
		add(WHICHONE);

		//Buttons bounds set
		Days7.setBounds(700, 375, 200, 100);
		Days7.addActionListener(this);
		add(Days7);


		Days14.setBounds(700,500, 200, 100);
		Days14.addActionListener(this);
		add(Days14);

		title.setBounds(80, 0, 450,150);
		title.setFont(titleFont);
		add(title);

		// Music code credits: Aryan
		// Plays music on startup
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + "\\sounds\\background.wav").getAbsoluteFile());

			Clip clip = AudioSystem.getClip();

			clip.open(audioInputStream);

			clip.start();

		} catch(Exception ex) {

			System.out.println("Error with playing sound.");

			ex.printStackTrace();

		}



	}


	// 1. Change color of JFrame to BLUE
	// 2. Insert two JButtons for 7 and 14 days
	// 3. Setup JPanels to insert photos
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//Button is clicked
		//set startclass to not visible
		//start up instructions list
		//Depending on button clicked, daysleft variable will be changed
		if (event.getSource() == Days7) {
			this.setVisible(false);
			new Instructions();
			//7 days now to play in the game
			DrinkingMoney.daysleft = 7;
		}
		else if (event.getSource() == Days14) {
			this.setVisible(false);
			new Instructions();
			//14 days now to play in the game
			DrinkingMoney.daysleft = 14;
		}

	}
}

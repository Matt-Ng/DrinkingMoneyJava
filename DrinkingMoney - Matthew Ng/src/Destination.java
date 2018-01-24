/*
 * Lets player pick destination they want to sell their drinks
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Destination  extends JFrame implements ActionListener{
	//  implement JButtons for both Neighbourhood & Office Building
	JLabel title = new JLabel("Pick where you want to sell!");
	JButton School = new JButton("School Grounds");
	JButton Office = new JButton("Office Building");

	public Destination(){
		setVisible(true);
		setSize(500,350);
		setLayout(null);
		getContentPane().setBackground(DrinkingMoney.babyblue);		
		Font titleFont = new Font("Arial", Font.PLAIN,30);
		// Heading of the JFrame, setting bounds and font
		title.setBounds(50, 25, 400,100);
		title.setFont(titleFont);
		add(title);

		// Setting bounds for school and office button bounds
		School.setBounds(25, 175, 200, 100);
		add(School);
		Office.setBounds(260, 175, 200, 100);
		add(Office);

		// adding actionlistener to each button

		School.addActionListener(this);
		Office.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// 1. Hide destination class
		// 1.1 Set isSchool to true or false depending on button picked
		// 2. Start Play Class
		if (event.getSource() == School) {
			// isschool is true
			DrinkingMoney.isSchool = true;
			// start play class
			new Play();
			//hide this class
			this.setVisible(false);
		}

		else if(event.getSource() == Office){
			// isschool is faflse
			DrinkingMoney.isSchool = false;
			// start play class
			new Play();
			//hide this class
			this.setVisible(false);
		}
		// TODO Auto-generated method stub


	}

}

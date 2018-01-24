import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Play extends JFrame implements ActionListener{
	//JPanel for various game stats
	JPanel stats = new JPanel();
	//Set picture in the class
	JLabel options =  new JLabel(new ImageIcon("images/default play 1.png"));



	// time variable
	int timeleft = 10;

	//initiate variables for ratings of drink
	double ratelemonade;
	double ratecoffee; 

	//JLabels for general information
	JLabel time = new JLabel("Time left: " + timeleft);
	JLabel play = new JLabel("Start Selling!");
	JLabel Statshead = new JLabel("Stats");
	JLabel Money = new JLabel("Money: $" + DrinkingMoney.Money );
	JLabel Days = new JLabel("Days Left: " + DrinkingMoney.daysleft);
	JLabel reputation = new JLabel("reputation 🐍 : " + DrinkingMoney.reputation);

	// Fonts for JLabels
	Font headerFont = new Font("Arial", Font.PLAIN, 18);
	Font titleFont = new Font("Arial", Font.PLAIN, 30);



	public Play(){
		// Constructor class

		// set dimensions of the JFrame
		setVisible(true);
		setSize(850,700);
		setLayout(null);
		getContentPane().setBackground(DrinkingMoney.babyblue);		

		// Heading of whole class JLabel
		play.setBounds(80, 20, 200,50);
		play.setFont(titleFont);
		add(play);

		// Centre JPanel, setting bounds
		options.setBounds(10, 100, 800, 400);
		add(options);

		//show general stats in this JPanel
		stats.setBounds(10, 510 , 800,140);
		add(stats);

		// Header for the stats JPanel
		Statshead.setBounds(25,15, 150,15);
		Statshead.setFont(headerFont);
		stats.add(Statshead);
		stats.setLayout(null);

		// Bounds for the JLabels in the stats JPanel, except for time which is just in the general JFrame
		Money.setBounds(50, 35, 150, 75);
		Money.setFont(headerFont);
		Days.setBounds(300,35,150,75);
		Days.setFont(headerFont);
		time.setBounds(500, 25, 150, 75);
		time.setFont(headerFont);
		add(time);
		reputation.setBounds(550,35,150,75);
		reputation.setFont(new Font("serif", Font.BOLD, 18));

		stats.add(Money); stats.add(Days); stats.add(reputation);

		// Timer Code Credits https://stackoverflow.com/questions/13805569/display-a-countdown#comment18994595_13805694
		// timer to be able to make the play class a certain amount of time, simulating a day
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				//update JLabel for time timer iteration, and also decrease the timeleft by 1 each time				
				time.setText("Time left: " + timeleft--);
				if(timeleft == 0) {
					endday();
				}
			}
		});
		// start timer
		timer.start();



	}


	public void rateLemonade(){
		// divide the ingredients of the lemonade to determine a ratio
		double lemonratio = DrinkingMoney.rlemons/DrinkingMoney.rwatercupslemon;
		// use the ratio to find the rating of the lemonade, basically its best at a 1:1 ratio in a school yard
		if(lemonratio <= 0.99 && lemonratio > 0.33) {
			//find score based of ratio
			if(DrinkingMoney.isSchool = true) {
				ratelemonade = 4;
			}
			else{
				ratelemonade = 2;
			}
		}
		else if(lemonratio == 1) {
			if(DrinkingMoney.isSchool = true) {
				ratelemonade = 6;
			}
			else{
				ratelemonade = 3;
			}
		}

		else if(lemonratio < 0.33) {
			ratelemonade = 1;
		}
	}	

	public void rateCoffee() {
		// divide the ingredients of the coffee to determine a ratio, specifically coffee and milk, since they are the valuable ingredients
		double coffeeratio = DrinkingMoney.rcoffeetbsp/DrinkingMoney.rmilkcups;
		// use the ratio to find the rating of the coffee, basically its best at a 1:1 ratio 
		if(coffeeratio <= 0.99 && coffeeratio > 0.33) {
			// based on each ratio, find the score of the coffee
			if(DrinkingMoney.isSchool = false) {
				ratecoffee = 4;
			}
			else{
				ratecoffee= 2;
			}
		}
		else if(coffeeratio == 1) {
			if(DrinkingMoney.isSchool = false) {
				ratecoffee = 6;
			}
			else{
				ratecoffee = 3;
			}
		}

		else if(coffeeratio < 0.33) {
			ratecoffee = 1;
		}
	}

	public void buy() {
		// each day has potentially 6 buys for each drink, basically 12 in total use random int to determine if its a buy
		// generate random number each time
		// the money added per purchase is high because of the low amount of sales that can happen

		//lemonade sales
		for(int i = 6; i>0; i--) {
			Random rand = new Random();
			int decisions = rand.nextInt(10)+1;	
			if(ratelemonade == 6) {
				// at highest rating, the player will get every possible sale, no luck required
				// depleting resources used for each drink sold
				DrinkingMoney.Lemons -= DrinkingMoney.rlemons;
				DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsplemon;
				DrinkingMoney.cupswater -= DrinkingMoney.rwatercupslemon;
				DrinkingMoney.cups--;
				DrinkingMoney.Money += 7;
				DrinkingMoney.reputation += 2;
			}
			else if(ratelemonade == 4) {
				if(decisions == 4 || decisions == 3 || decisions == 2 || decisions == 1) {
					// depleting resources used for each drink sold
					DrinkingMoney.Lemons -= DrinkingMoney.rlemons;
					DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsplemon;
					DrinkingMoney.cupswater -= DrinkingMoney.rwatercupslemon;
					DrinkingMoney.cups--;
					DrinkingMoney.Money += 7;
					DrinkingMoney.reputation += 1;
				}
				else{
					// if random number is not chosen, nothing happens
					DrinkingMoney.Money +=0;
				}
			}
			else {
				if(decisions == 4 || decisions == 3 ) {
					// depleting resources used for each drink sold
					DrinkingMoney.Lemons -= DrinkingMoney.rlemons;
					DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsplemon;
					DrinkingMoney.cupswater -= DrinkingMoney.rwatercupslemon;
					DrinkingMoney.cups--;
					DrinkingMoney.Money += 7;
				}

			}



		}
		// coffee purchases
		for(int i = 6; i>0; i--) {
			Random rand = new Random();
			int decisions = rand.nextInt(10)+1;	
			if(ratecoffee == 6) {
				// at highest rating, the player will get every possible sale, no luck required
				// depleting resources used for each drink sold
				DrinkingMoney.coffeetbsp -= DrinkingMoney.rcoffeetbsp;
				DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsp;
				DrinkingMoney.milkpacks -= DrinkingMoney.rmilkcups;
				DrinkingMoney.cups--;
				DrinkingMoney.Money += 10;
				DrinkingMoney.reputation += 2;
			}
			else if(ratecoffee == 4) {
				if(decisions == 4 || decisions == 3 || decisions == 2 || decisions == 1) {
					DrinkingMoney.coffeetbsp -= DrinkingMoney.rcoffeetbsp;
					DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsp;
					DrinkingMoney.milkpacks -= DrinkingMoney.rmilkcups;
					DrinkingMoney.cups--;
					DrinkingMoney.Money += 10;
					DrinkingMoney.reputation += 1;
				}
				else{
					DrinkingMoney.Money +=0;
				}
			}
			else {
				if(decisions == 4 || decisions == 3 ) {
					DrinkingMoney.coffeetbsp -= DrinkingMoney.rcoffeetbsp;
					DrinkingMoney.sugartbsp -= DrinkingMoney.rsugartbsp;
					DrinkingMoney.milkpacks -= DrinkingMoney.rmilkcups;
					DrinkingMoney.cups--;
					DrinkingMoney.Money += 10;
				}

			}
		}


	}

	public void endday() {
		this.setVisible(false);
		DrinkingMoney.daysleft--;
		buy();
		if(DrinkingMoney.daysleft > 0) {
			new IngredientsShop();

		}

		if(DrinkingMoney.daysleft == 0) {
			new endgame();
		}

		// hide play
		// go to ingredientsshop, or if days are over to end game
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Halve timer ticks
	}

}

/*
 * 
 * This class lets users purchase items for their drinks
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class IngredientsShop extends JFrame implements ActionListener{

	// Initialize JPanels and Buttons for purchases in game
	JPanel options = new JPanel();
	JPanel ingredients = new JPanel();
	JPanel stats = new JPanel();
	JButton s20 = new JButton("20 TBSP Sugar, $2");
	JButton s10 = new JButton("10 TBSP Sugar, $1");
	JButton w10 = new JButton("10 cups water, $1");
	JButton w20 = new JButton("20 cups water, $2");
	JButton c10 = new JButton("10 Drink cups, $1");
	JButton c20 = new JButton("20 Drink cups, $2");
	JButton cof10 = new JButton("10 TBSP Coffee, $2");
	JButton cof20 = new JButton("20 TBSP Coffee, $4");
	JButton m10 = new JButton("10 pkts Milk, $2");
	JButton m20 = new JButton("10 pkts Milk, $4");
	JButton l10 = new JButton("10 Lemons, $5");
	JButton l20 = new JButton("20 Lemons, $10");

	JLabel Title = new JLabel("Ingredients Shop!");
	JButton Next = new JButton("To the drink maker!");

	//JPanel elements for general stats
	JLabel Statshead = new JLabel("Stats");
	JLabel Money = new JLabel("Money: $" + DrinkingMoney.Money );
	JLabel Days = new JLabel("Days Left: " + DrinkingMoney.daysleft);
	JLabel reputation = new JLabel("reputation 🐍 : " + DrinkingMoney.reputation);
	JLabel Sugar = new JLabel(DrinkingMoney.sugartbsp + " TBSP sugar");
	JLabel Water = new JLabel(DrinkingMoney.cupswater + " cups of water");
	JLabel Cups = new JLabel(DrinkingMoney.cups + " Drinking Cups");
	JLabel Coffee = new JLabel(DrinkingMoney.cups + " TBSP of Coffee");
	JLabel Milk = new JLabel(DrinkingMoney.milkpacks + " packets of milk");
	JLabel Lemons = new JLabel(DrinkingMoney.Lemons + " Lemons");


	public IngredientsShop(){
		setVisible(true);
		setSize(1000,700);
		setLayout(null);
		getContentPane().setBackground(DrinkingMoney.babyblue);		

		Next.setBounds(815, 535, 150, 100);
		Next.addActionListener(this);
		add(Next);

		Font titleFont = new Font("Arial", Font.PLAIN, 30);
		Title.setBounds(80, 20, 450,50);
		Title.setFont(titleFont);
		add(Title);


		ingredients.setBounds(825, 20, 150, 500);
		add(ingredients);

		Font headerFont = new Font("Arial", Font.PLAIN, 18);

		//show general stats in this JPanel
		stats.setBounds(10, 510 , 800,140);
		add(stats);

		Statshead.setBounds(25,15, 150,15);
		Statshead.setFont(headerFont);
		stats.add(Statshead);
		stats.setLayout(null);

		Money.setBounds(50, 35, 150, 75);
		Money.setFont(headerFont);
		Days.setBounds(300,35,150,75);
		Days.setFont(headerFont);
		reputation.setBounds(550,35,150,75);
		reputation.setFont(new Font("serif", Font.BOLD, 18));

		stats.add(Money); stats.add(Days); stats.add(reputation);


		// Set up JPanel to House Stats on Each Ingredient
		ingredients.setBounds(825, 20, 150, 500);
		add(ingredients);
		ingredients.setLayout(null);
		Sugar.setBounds(30, 65, 150, 50);
		Water.setBounds(30, 125, 150, 50);
		Cups.setBounds(30, 185, 150, 50);
		Coffee.setBounds(30, 245, 150, 50);
		Milk.setBounds(30,  305, 150, 50);
		Lemons.setBounds(30, 365, 150, 50);


		// adding elements to ingredients JPanel
		ingredients.add(Sugar);ingredients.add(Water); ingredients.add(Cups); ingredients.add(Coffee);
		ingredients.add(Milk); ingredients.add(Lemons); 



		// setting bounds for JPanels and buttons
		options.setBounds(10, 100, 800, 400);
		add(options);
		stats.setBounds(10, 510 , 800,140);
		add(stats);
		s10.setBounds(30, 30, 150, 75);
		s20.setBounds(30, 115, 150, 75);
		w10.setBounds(325, 30, 150, 75);
		w20.setBounds(325, 115, 150, 75);
		c10.setBounds(620, 30, 150, 75);
		c20.setBounds(620, 115, 150, 75);
		cof10.setBounds(30, 235, 150, 75);
		cof20.setBounds(30, 320, 150, 75);
		m10.setBounds(325, 235, 150, 75);
		m20.setBounds(325, 320, 150, 75);
		l10.setBounds(620, 235, 150, 75);
		l20.setBounds(620, 320, 150, 75);

		//adding actionlistener to each button
		s20.addActionListener(this);
		s10.addActionListener(this);
		w10.addActionListener(this);
		w20.addActionListener(this);
		c10.addActionListener(this);
		c20.addActionListener(this);
		cof10.addActionListener(this);
		cof20.addActionListener(this);
		m10.addActionListener(this);
		m20.addActionListener(this);
		l10.addActionListener(this);
		l20.addActionListener(this);



		options.setLayout(null);
		// adding buttons to options JPanel
		options.add(s10); options.add(s20);options.add(w10); options.add(w20); options.add(c10); options.add(c20);
		options.add(cof10); options.add(cof20); options.add(m10); options.add(m20); options.add(l10); options.add(l20);
	}

	// 1. Change color to BLUE
	// 2. Implement JPanel to house all ingredients
	// 3. set money variable to 20.00 for starting money
	// 4. Implement JButtons to be able to purchase ingredients
	//4.1 each button will subtract money, but add to ingredients variables
	// 5. Set up JPanel to House Stats on Each Ingredient
	// 5.1 Display all stats using a JLabel
	// 6. Set up JPanel to show player stats like money, reputation
	// 6.1 Display all stats using a JLabel
	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == Next) {
			// TODO Auto-generated method stub
			//Continue to beverage customizer
			//Hide Ingredientshop
			// Start DrinkRecipe Class
			this.setVisible(false);
			new DrinkRecipe();
		}

		//all buttons including, and after s10 add certain ingredients to each inv
		else if (event.getSource() == s10) {
			if(DrinkingMoney.Money -1 > 0) {
				//subtract money
				DrinkingMoney.Money -= 1;
				// add sugar/ any other ingredient
				DrinkingMoney.sugartbsp += 10;
				// update JLabels after transactions
				Sugar.setText(DrinkingMoney.sugartbsp + " TBSP sugar");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				// if there isn't money left, nothing will happen
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == s20) {
			if(DrinkingMoney.Money - 2 > 0) {
				DrinkingMoney.Money -= 2;
				DrinkingMoney.sugartbsp += 20;
				Sugar.setText(DrinkingMoney.sugartbsp + " TBSP sugar");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == w10) {
			if(DrinkingMoney.Money -1 > 0) {
				DrinkingMoney.Money -= 1;
				DrinkingMoney.cupswater += 10;
				Water.setText(DrinkingMoney.cupswater + " cups of water");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == w20) {
			if(DrinkingMoney.Money - 2 > 0) {
				DrinkingMoney.Money -= 2;
				DrinkingMoney.cupswater += 20;
				Water.setText(DrinkingMoney.cupswater + " cups of water");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == c10) {
			if(DrinkingMoney.Money -1 > 0) {
				DrinkingMoney.Money -= 1;
				DrinkingMoney.cups += 10;
				Cups.setText(DrinkingMoney.cups+ " Drinking Cups");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == c20) {
			if(DrinkingMoney.Money -2 > 0) {
				DrinkingMoney.Money -= 2;
				DrinkingMoney.cups += 20;
				Cups.setText(DrinkingMoney.cups+ " Drinking Cups");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == cof10) {
			if(DrinkingMoney.Money -2 > 0) {
				DrinkingMoney.Money -= 2;
				DrinkingMoney.coffeetbsp += 10;
				Coffee.setText(DrinkingMoney.coffeetbsp+ " TBSP of Coffee");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == cof20) {
			if(DrinkingMoney.Money -4 > 0) {
				DrinkingMoney.Money -= 4;
				DrinkingMoney.coffeetbsp += 20;
				Coffee.setText(DrinkingMoney.coffeetbsp+ " TBSP of Coffee");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money += 0;
			}

		}

		else if (event.getSource() == m10) {
			if(DrinkingMoney.Money -2 > 0) {
				DrinkingMoney.Money -= 2;
				DrinkingMoney.milkpacks += 10;
				Milk.setText(DrinkingMoney.milkpacks+ " packets of milk");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money +=0;
			}
		}

		else if (event.getSource() == m20) {
			if(DrinkingMoney.Money -4 > 0) {
				DrinkingMoney.Money -= 4;
				DrinkingMoney.milkpacks += 20;
				Milk.setText(DrinkingMoney.milkpacks+ " packets of milk");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money +=0;
			}
		}

		else if (event.getSource() == l10) {
			if(DrinkingMoney.Money -5 > 0) {
				DrinkingMoney.Money -= 5;
				DrinkingMoney.Lemons += 10;
				Lemons.setText(DrinkingMoney.Lemons+ " Lemons");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money +=0;
			}
		}

		else if (event.getSource() == l20) {
			if(DrinkingMoney.Money -10 > 0) {
				DrinkingMoney.Money -= 10;
				DrinkingMoney.Lemons += 20;
				Lemons.setText(DrinkingMoney.Lemons+ " Lemons");
				Money.setText("Money: $" + DrinkingMoney.Money );
			}
			else {
				DrinkingMoney.Money +=0;
			}
		}


	}



}

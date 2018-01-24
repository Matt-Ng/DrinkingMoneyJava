/*
 * 
 * Lets user select the drink recipe
 * 
 */


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DrinkRecipe  extends JFrame implements ActionListener{

	// Adding the buttons, JLabels and JPanels for the GUI and to be able to give user input to add or subtract an item from the recipe
	JLabel Lemonade = new JLabel("Lemonade");
	JLabel Coffee = new JLabel("Coffee");
	JPanel ingredients = new JPanel();
	JPanel options = new JPanel();
	JPanel stats = new JPanel();
	JLabel Title = new JLabel("Make your drinks!" );
	JButton adds1 = new JButton("+ 1 TBSP Sugar");// add 1 tbsp sugar lemonade
	JButton subs1 = new JButton("- 1 TBSP Sugar");// sub 1 tbsp sugar lemonade
	JButton addw1 = new JButton("+ 1 cup of water");// add 1 cup of water lemonade
	JButton subw1 = new JButton("- 1 cup of water");// sub 1 cup of water lemonade
	JButton addl1 = new JButton("+ 1 lemon");
	JButton subl1 = new JButton("- 1 lemon");
	JButton adds2 = new JButton("+ 1 TBSP Sugar");
	JButton subs2 = new JButton("- 1 TBSP Sugar");
	JButton addw2 = new JButton("+ 1 cup of milk");
	JButton subw2 = new JButton("- 1 cup of milk");
	JButton addl2 = new JButton("+ 1 TBSP coffee");
	JButton subl2 = new JButton("- 1 TBSP coffee");



	//Jpanel elements for recipe stats
	JLabel headLemon = new JLabel("Lemonade");
	JLabel tsugarlemon = new JLabel(DrinkingMoney.rsugartbsplemon + " TBSP of Sugar");
	JLabel lemons = new JLabel(DrinkingMoney.rlemons + " Lemons");
	JLabel water = new JLabel(DrinkingMoney.rwatercupslemon + " cups of water");
	JLabel tcoffee = new JLabel(DrinkingMoney.rcoffeetbsp + " TBSP of Coffee");
	JLabel tsugarcoffee =  new JLabel(DrinkingMoney.rsugartbsp + " TBSP of sugar");
	JLabel tmilk = new JLabel(DrinkingMoney.rmilkcups + " milk packets");
	JLabel headCoffee = new JLabel("Coffee");

	//JPanel elements for general stats
	JLabel Statshead = new JLabel("Stats");
	JLabel Money = new JLabel("Money: $" + DrinkingMoney.Money );
	JLabel Days = new JLabel("Days Left: " + DrinkingMoney.daysleft);
	JLabel reputation = new JLabel("reputation 🐍 : " + DrinkingMoney.reputation);

	JButton Next = new JButton("Next!");

	public DrinkRecipe(){
		setVisible(true);
		setSize(1000, 700);
		setLayout(null);
		// 1. Change color to BLUE
		getContentPane().setBackground(DrinkingMoney.babyblue);		

		// set up fonts for title, and headers of ingredients JPanel
		Font titleFont = new Font("Arial", Font.PLAIN, 30);
		Font headerFont = new Font("Arial", Font.PLAIN, 18);
		// Set up JPanel to House Stats on Each Ingredient
		ingredients.setBounds(825, 20, 150, 500);
		add(ingredients);
		ingredients.setLayout(null);
		headLemon.setFont(headerFont);
		headLemon.setBounds(35, 0, 150, 50);
		ingredients.add(headLemon);
		tsugarlemon.setBounds(30, 65, 150, 50);
		lemons.setBounds(30, 125, 150, 50);
		water.setBounds(30, 185, 150, 50);
		headCoffee.setBounds(35, 245, 150, 50);
		headCoffee.setFont(headerFont);
		tcoffee.setBounds(30, 285, 150, 50);
		tsugarcoffee.setBounds(30, 345, 150, 50);
		tmilk.setBounds(30, 415, 150, 50);


		ingredients.add(tsugarlemon);ingredients.add(lemons); ingredients.add(water); ingredients.add(headCoffee);
		ingredients.add(tcoffee); ingredients.add(tsugarcoffee); ingredients.add(tmilk);

		Title.setBounds(80, 20, 450,50);
		Title.setFont(titleFont);
		add(Title);
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

		Next.setBounds(815, 535, 150, 100);
		Next.addActionListener(this);
		add(Next);

		// Set up JPanel to give options for recipe of each drink
		options.setBounds(10, 100, 800, 400);
		add(options);


		// set the dimensions of the buttons within the JPanel
		adds1.setBounds(30, 75, 150, 75);
		subs1.setBounds(190, 75, 150, 75);
		addw1.setBounds(30, 160, 150, 75);
		subw1.setBounds(190, 160, 150, 75);
		addl1.setBounds(30, 245, 150, 75);
		subl1.setBounds(190, 245, 150, 75);
		adds2.setBounds(425, 75, 150, 75);
		subs2.setBounds(585, 75, 150, 75);
		addw2.setBounds(425, 160, 150, 75);
		subw2.setBounds(585, 160, 150, 75);
		addl2.setBounds(425, 245, 150, 75);
		subl2.setBounds(585, 245, 150, 75);


		// JLabel for "Lemonade"
		Lemonade.setBounds(100, 0, 150, 75);
		Lemonade.setFont(titleFont);

		// JLabel for "Coffee"
		Coffee.setBounds(525, 0, 150,75);
		Coffee.setFont(titleFont);

		// Implement JPanels to show each beverage customizer
		options.setLayout(null);
		options.add(adds2); options.add(subs2); options.add(addw2); options.add(subw2); options.add(addl2); options.add(subl2);
		options.add(adds1); options.add(Lemonade); options.add(Coffee); options.add(subs1); options.add(addw1);options.add(subw1);
		options.add(addl1); options.add(subl1);
		// plug actionlistener into buttons
		adds1.addActionListener(this);
		subs1.addActionListener(this);
		addw1.addActionListener(this);
		subw1.addActionListener(this);
		addl1.addActionListener(this);
		subl1.addActionListener(this);
		adds2.addActionListener(this);
		subs2.addActionListener(this);
		addw2.addActionListener(this);
		subw2.addActionListener(this);
		addl2.addActionListener(this);
		subl2.addActionListener(this);


	}

	// 5.1 Display all stats using a JLabel
	// 6. Set up JPanel to show player stats like money, reputation
	// 6.1 Display all stats using a JLabel
	@Override
	public void actionPerformed(ActionEvent event) {
		
		/*
		 * 
		 * For each button, the inv for each ingredient in each recipe will update a JLabel and the variable
		 * 
		 */
		if (event.getSource() == adds1) {
			DrinkingMoney.rsugartbsplemon++;
			tsugarlemon.setText(DrinkingMoney.rsugartbsplemon + " TBSP of Sugar");		

		}
		else if (event.getSource() == subs1) {
			DrinkingMoney.rsugartbsplemon--;
			tsugarlemon.setText(DrinkingMoney.rsugartbsplemon + " TBSP of sugar");		
		}
		else if (event.getSource() == addw1) {
			DrinkingMoney.rwatercupslemon++;
			water.setText(DrinkingMoney.rwatercupslemon + " cups of water");		
		}
		else if (event.getSource() == subw1) {
			DrinkingMoney.rwatercupslemon--;
			water.setText(DrinkingMoney.rwatercupslemon + " cups of water");		
		}
		else if (event.getSource() == addl1) {
			DrinkingMoney.rlemons++;
			lemons.setText(DrinkingMoney.rlemons + " Lemons");		
		}
		else if (event.getSource() == subl1) {
			DrinkingMoney.rlemons--;
			lemons.setText(DrinkingMoney.rlemons + " Lemons");		
		}
		else if (event.getSource() == adds2) {
			DrinkingMoney.rsugartbsp++;
			tsugarcoffee.setText(DrinkingMoney.rsugartbsp + " TBSP of sugar");		
		}
		else if (event.getSource() == subs2) {
			DrinkingMoney.rsugartbsp--;
			tsugarcoffee.setText(DrinkingMoney.rsugartbsp + " TBSP of sugar");		
		}
		else if (event.getSource() == addw2) {
			DrinkingMoney.rmilkcups++;
			tmilk.setText(DrinkingMoney.rmilkcups + " milk packets");		
		}
		else if (event.getSource() == subw2) {
			DrinkingMoney.rmilkcups--;
			tmilk.setText(DrinkingMoney.rmilkcups + " milk packets");		
		}
		else if (event.getSource() == addl2) {
			DrinkingMoney.rcoffeetbsp++;
			tcoffee.setText(DrinkingMoney.rcoffeetbsp + " TBSP of Coffee");		
		}
		else if (event.getSource() == subl2) {
			DrinkingMoney.rcoffeetbsp--;
			tcoffee.setText(DrinkingMoney.rcoffeetbsp + " TBSP of Coffee");		
		}

		else if (event.getSource() == Next) {
			this.setVisible(false);
			new Destination();
		}


		// TODO Auto-generated method stub
		// 1 Update the ingredients variables
		// 1.1 If the recipe calls for too much, don't let the JButton work
		// 2. Hide Ingredientshop
		// 3. Start DrinkRecipe Class
	}

}

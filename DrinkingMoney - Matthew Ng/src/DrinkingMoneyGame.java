/*
 * 
 * Matthew Ng
 * Jan 19, 2018
 * ICS3U1-01
 * Drinking Money 
 * A beverage stand simulator that lets you make and sell your own beverages
 * You get to manage your money and be able to ration resources effectively
 * 
 * Features to notice: Background music, timer counting down in play class which will open a new class, 
 * being able to purchase ingredients, where you can see the money decrease and ingredients increase
 * after each "day", the day decreases, and there are updates on the stats of the ingredients, money, and day
 * 
 * Programming skills: Used for loops, static variables, that are referenced across classes, GUI design with swing GUI, Time Management
 * 
 * Errors/Partial Solutions: In the play class, the graphic is not animated, was not able to use timer
 * 
 * The play class, for endday method, it doesn't check for sold out ingredients
 * 
 */
public class DrinkingMoneyGame {


	// main method lets the game be started
	public static void main(String[] args) {
		new StartClass();
	}
}

package IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		Stack<Double> micheal = new Stack<Double>();
		// Don't forget to import the Stack class

		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i <= 100; i++) {
			Random r = new Random();
			micheal.push(r.nextDouble() * 100);
		}
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String j = JOptionPane.showInputDialog("Enter a number between 0 and 100, inclusive");
		int w = Integer.parseInt(j);
		String k = JOptionPane.showInputDialog("Enter another number between 0 and 100, inclusive");
		int a = Integer.parseInt(k);
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		int size = micheal.size();
		for (int i = 0; i < size; i++) {
			micheal.pop();
			if ((w <= micheal.peek() && micheal.peek() <= a) || (w >= micheal.peek() && micheal.peek() >= a)) {
				System.out.println(micheal.pop());
			}
		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}

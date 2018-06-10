package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> letter = new Stack<Character>();
	Stack<Character> delete = new Stack<Character>();

	public static void main(String[] args) {
		TextUndoRedo jerry = new TextUndoRedo();
		jerry.ui();
	}

	void ui() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == (KeyEvent.VK_BACK_SPACE)) {
			if (!letter.empty()) {
				delete.push(letter.pop());
			} 
		} else if(e.getKeyCode()==(KeyEvent.VK_CONTROL)){
			if(!delete.empty()){
				letter.push(delete.pop());
			}
			System.out.println("reee");
		} else if(e.getKeyCode()==(KeyEvent.VK_SHIFT)){
			
		} else {
			letter.push(e.getKeyChar());
		}
		int size = letter.size();
		String text = "";
		if (!letter.empty()) {
			for (int i = 0; i < size; i++) {
				text += letter.get(i);
			}
		}
		label.setText(text);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

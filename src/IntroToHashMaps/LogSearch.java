package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> mcdonald = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Entry");
	JButton search = new JButton("Search by ID");
	JButton view = new JButton("View List");
	JButton remove = new JButton("Remove Entry");

	public static void main(String[] args) {
		LogSearch lincoln = new LogSearch();
		lincoln.ui();
	}

	void ui() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.pack();
		frame.setVisible(true);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(add)) {
			String in = JOptionPane.showInputDialog("Enter in a number.");
			int key = Integer.parseInt(in);
			String value = JOptionPane.showInputDialog("Enter in a name.");
			mcdonald.put(key, value);
		}
		if (e.getSource().equals(search)) {
			String ids = JOptionPane.showInputDialog("Enter an ID number.");
			int id = Integer.parseInt(ids);
			if (mcdonald.containsKey(id)) {
				JOptionPane.showMessageDialog(null, "" + mcdonald.get(id));
			} else {
				JOptionPane.showMessageDialog(null, "That entry does not exist.");
			}
		}
		if (e.getSource().equals(view)) {
			String lil = "";
			for(Integer s : mcdonald.keySet()) {
				lil += "ID: "+s+" Name: "+mcdonald.get(s) + "\n";
			}
			JOptionPane.showMessageDialog(null, lil);
		}
		if(e.getSource().equals(remove)) {
			String aids = JOptionPane.showInputDialog("Enter an ID number.");
			int aid = Integer.parseInt(aids);
			if (mcdonald.containsKey(aid)) {
				mcdonald.remove(aid);
				JOptionPane.showMessageDialog(null, "ID successfully removed.");
			} else {
				JOptionPane.showMessageDialog(null, "That entry does not exist.");
			}
		}
	}
}

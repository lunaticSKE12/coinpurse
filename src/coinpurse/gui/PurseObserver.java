package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class PurseObserver extends JFrame implements Observer{
	
	private JTextArea textArea;
	private static final int FONT_SIZE = 40;
	
	public PurseObserver(){
		super("Purse Balance");
		initComponents();
	}

	private void initComponents() {
		textArea = new JTextArea(2,5);
		textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		
		this.add(textArea);
		this.pack();
	}
	
	public void run(){
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Purse purse = new Purse(0);
		if ( arg0 instanceof Purse){
			purse = (Purse) arg0;
			int balance = (int) purse.getBalance();
		}
		
		textArea.setText(purse.getBalance() + " Baht");
	}

}

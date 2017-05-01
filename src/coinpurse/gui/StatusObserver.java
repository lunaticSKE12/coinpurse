package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class StatusObserver extends JFrame implements Observer {

	private JTextArea textArea;
	private static final int FONT_SIZE = 40;
	private JProgressBar progressBar;

	public StatusObserver(){
		super("Status");
		initComponents();
	}

	private void initComponents() {

		textArea = new JTextArea(2,5);
		textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		progressBar = new JProgressBar(0,10);
		this.add(progressBar,BorderLayout.SOUTH);
		this.add(textArea,BorderLayout.NORTH);
		this.pack();

	}
	
	public void run(){
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if( arg0 instanceof Purse){
			Purse purse = (Purse) arg0;
			if(purse.isFull()){
				textArea.setText("FULL");
			}
			else
				textArea.setText(purse.count() + "/" + purse.getCapacity());
			progressBar.setValue(purse.count());
		}

	}

}

package Summer2014_2015;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BUTTONSSSSSSSSSS implements ActionListener{
	static JFrame frame;
	static JLabel label;
	static JLabel label1;
	static JLabel label2;
	static JButton button;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	static JButton button5;
	static JButton button6;
	static JButton button7;
	static JButton button8;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		button = new JButton();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		
		label = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		
		
		
		frame  = new JFrame();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(false);
			}
		});
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				button1.setEnabled(false);
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				button2.setEnabled(false);
			}
		});
		button.setSize(20, 20);
		frame.setTitle("SPOOPS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3,3));
		frame.setSize(500, 500);
		frame.add(button);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

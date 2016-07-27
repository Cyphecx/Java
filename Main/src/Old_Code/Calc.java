package Old_Code;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Calc extends JFrame implements ActionListener{
JTextField txt = new JTextField();
JButton button = new JButton();
JLabel label = new JLabel();
	public static void main(String[] args) {
		new Calc();
	}
	public Calc(){
		setTitle("SPOOPS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(700, 200);
		setLayout(new FlowLayout());
		add(txt);
		add(button);
		add(label);
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(80,50));
		button.setText("Enter");
		label.setText("Enter in math sequence");
		txt.setPreferredSize(new Dimension(500,50));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	System.out.println(""+txt.getText());
	}

}

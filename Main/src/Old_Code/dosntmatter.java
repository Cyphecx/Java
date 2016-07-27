package Old_Code;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class dosntmatter extends JFrame implements ActionListener{
	int turn;
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();	
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();
	JButton[][] buttons=new JButton[3][3];
	public static void main(String[] args) {
		new dosntmatter();
	}
	public dosntmatter(){
		setTitle("SPOOPS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(3,3));
		setSize(500, 500);
		button1.addActionListener(this);
		int k = 0;
		for (k = 0; k < 3; k ++){

			for (int e = 0; e < 3; e ++){
				buttons[k][e] = new JButton();
				buttons[k][e].addActionListener(this);
				add(buttons[k][e]);
				buttons[k][e].setText("Empty");
				buttons[k][e].setBorderPainted(false);
				buttons[k][e].setFont(new Font(null,Font.PLAIN,25));
			} 

		}

	}
	@Override
	public void actionPerformed(ActionEvent p) {
		for (int k = 0; k < 3; k ++){

			for (int e = 0; e < 3; e ++){
				if(p.getSource().equals(buttons[k][e])){

					if(turn%2==0){
						buttons[k][e].setText("X");
					}
					else{
						buttons[k][e].setText("O");
					}
					buttons[k][e].setEnabled(false);
					turn++;
				}
				for (int g = 0; g < 3; g ++){

					for (int h = 0; h < 3; h ++){
						if (buttons[g][0].getText().equals("X")&& buttons[g][1].getText().equals("X") &&buttons[g][2].getText().equals("X")){
							getContentPane().removeAll();
							setLayout(new FlowLayout());
							label.setFont(new Font(null,Font.PLAIN,50));
							label.setPreferredSize(new Dimension(350,450));
							label.setText("Player X wins!");
							add(label);
							pack();
							setSize(500,500);
							return;
						}
					}
					if(buttons[0][g].getText().equals("X")&& buttons[1][g].getText().equals("X")&&buttons[2][g].getText().equals("X")){
						getContentPane().removeAll();
						setLayout(new FlowLayout());
						label.setFont(new Font(null,Font.PLAIN,50));
						label.setPreferredSize(new Dimension(350,450));
						label.setText("Player X wins!");
						add(label);
						pack();
						setSize(500,500);
						return;
					}

				}

			}
			if(buttons[0][0].getText().equals("X")&& buttons[1][1].getText().equals("X")&&buttons[2][2].getText().equals("X")){
				getContentPane().removeAll();
				setLayout(new FlowLayout());
				label.setFont(new Font(null,Font.PLAIN,50));
				label.setPreferredSize(new Dimension(350,450));
				label.setText("Player X wins!");
				add(label);
				pack();
				setSize(500,500);
				return;
			}
			if(buttons[0][2].getText().equals("X")&& buttons[1][1].getText().equals("X")&&buttons[2][0].getText().equals("X")){
				getContentPane().removeAll();
				setLayout(new FlowLayout());
				label.setFont(new Font(null,Font.PLAIN,50));
				label.setPreferredSize(new Dimension(350,450));
				label.setText("Player X wins!");
				add(label);
				pack();
				setSize(500,500);
				return;
			}

			for (int g = 0; g < 3; g ++){

				for (int h = 0; h < 3; h ++){
					if (buttons[g][0].getText().equals("O")&& buttons[g][1].getText().equals("O") &&buttons[g][2].getText().equals("O")){
						getContentPane().removeAll();
						setLayout(new FlowLayout());
						label.setFont(new Font(null,Font.PLAIN,50));
						label.setPreferredSize(new Dimension(350,450));
						label.setText("Player O wins!");
						add(label);
						pack();
						setSize(500,500);
						return;
					}
				}
				if(buttons[0][g].getText().equals("O")&& buttons[1][g].getText().equals("O")&&buttons[2][g].getText().equals("O")){
					getContentPane().removeAll();
					setLayout(new FlowLayout());
					label.setFont(new Font(null,Font.PLAIN,50));
					label.setPreferredSize(new Dimension(350,450));
					label.setText("Player O wins!");
					add(label);
					pack();
					setSize(500,500);
					return;
				}



			}
			if(buttons[0][0].getText().equals("O")&& buttons[1][1].getText().equals("O")&&buttons[2][2].getText().equals("O")){
				getContentPane().removeAll();
				setLayout(new FlowLayout());
				label.setFont(new Font(null,Font.PLAIN,50));
				label.setPreferredSize(new Dimension(350,450));
				label.setText("Player O wins!");
				add(label);
				pack();
				setSize(500,500);
				return;
			}
			if(buttons[0][2].getText().equals("O")&& buttons[1][1].getText().equals("O")&&buttons[2][0].getText().equals("O")){
				getContentPane().removeAll();
				setLayout(new FlowLayout());
				label.setFont(new Font(null,Font.PLAIN,50));
				label.setPreferredSize(new Dimension(350,450));
				label.setText("Player O wins!");
				add(label);
				pack();
				setSize(500,500);
				return;
			}
			
		}
		if(!buttons[0][0].getText().equals("Empty")&&!buttons[0][1].getText().equals("Empty")&&!buttons[0][0].getText().equals("Empty")&&!buttons[0][2].getText().equals("Empty")&&!buttons[1][0].getText().equals("Empty")&&!buttons[2][0].getText().equals("Empty")&&!buttons[1][1].getText().equals("Empty")&&!buttons[2][2].getText().equals("Empty")&&!buttons[0][0].getText().equals("Empty")){
			getContentPane().removeAll();
			setLayout(new FlowLayout());
			label.setFont(new Font(null,Font.PLAIN,50));
			label.setPreferredSize(new Dimension(350,450));
			label.setText("It's a Tie!");
			add(label);
			pack();
			setSize(500,500);
			return;
		}

		repaint();

	} 
	JLabel label = new JLabel();
}
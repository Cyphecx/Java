package Summer2014_2015;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Bookstore extends JFrame implements ActionListener{
	JButton button = new JButton();
	static JTextField txt = new JTextField();
	JLabel com = new JLabel();
	static Books book;
	static int lf;
	static String t;
	static String a;
	static int r;
	static int p;
	File bookl = new File("ookstore.txt");
	BufferedWriter writer1;

	public static void main(String[] args){
		new Bookstore();
	}
	public Bookstore(){
		setTitle("SPOOPS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 600);
		setLayout(new FlowLayout());
		add(button);
		button.addActionListener(this);
		button.setText("Enter");
		add(txt);
		add(com);
		com.setText("Select mode: search, add or buy (all lowercase please)");
		txt.setPreferredSize(new Dimension(500,50));

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(txt.getText().equals("search")){
			com.setText("What do you want to search by? title, author, rating or price");
			txt.setText("");
		}
		if(txt.getText().equals("add")){
			txt.setText("");
			com.setText("Enter title of book");
			lf++;
			return;
		}
		if(lf==1){
			t=txt.getText();
			txt.setText("");
			com.setText("Enter author name");
			lf++;
			return;
		}
		if(lf==2){
			a=txt.getText();
			txt.setText("");
			com.setText("Enter rating out of 5");
			lf++;
			return;
		}
		if(lf==3){
			r=Integer.parseInt(txt.getText());
			txt.setText("");
			com.setText("Enter Price");
			lf++;
			return;
		}
		if(lf==4){
			p=Integer.parseInt(txt.getText());
			book = new Books(t,a,r,p,1);
			txt.setText("");
			com.setText("is this what you entered? "+book.dc());
			lf++;
			return;
		}
		if(lf==5&&txt.equals("yes")){
			txt.setText("");
			try {
				writer1=new BufferedWriter(new FileWriter(bookl));
				writer1.write(book.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				writer1.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if(txt.getText().equals("title")){
			com.setText("Enter title");
			txt.setText("");
		}
		if(txt.getText().equals("author")){
			com.setText("Enter author");
			txt.setText("");
		}
		if(txt.getText().equals("rating")){
			com.setText("Enter rating");
			txt.setText("");
		}
		if(txt.getText().equals("price")){
			com.setText("Enter budget");
			txt.setText("");
		}

	}
}

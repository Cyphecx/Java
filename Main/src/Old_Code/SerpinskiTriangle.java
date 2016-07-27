package Old_Code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SerpinskiTriangle extends JFrame implements WindowListener{
	public static void main(String[] args) {
	new SerpinskiTriangle();
	
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,600,600);
		g.setColor(Color.YELLOW);
		hi(new int[] {0,512,256},new int[] {532,532,20},g);
	}
	public SerpinskiTriangle(){
		setTitle("SPOOPS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(600, 600);
		addWindowListener(this);
	}
	public void hi(int a[], int b[],Graphics g){
		if(a[1]-a[0]<=2){
			return;
		}
		g.drawPolygon(a,b, 3);
		//g.drawPolygon(new int[] {a[0],(a[1]+a[0])/2,(a[2]+a[0])/2}, new int[]{b[0],b[1],(b[1]+b[2])/2},3);
		hi(new int[] {(a[0]+a[2])/2,(a[2]+a[1])/2,a[2]}, new int[] {(b[0]+b[2])/2,(b[1]+b[2])/2,b[2]},g);
		hi(new int[] {a[0],(a[1]+a[0])/2,(a[2]+a[0])/2}, new int[]{b[0],b[1],(b[1]+b[2])/2},g);
		//System.out.println("khjdafgkjhdfgahkdfgkj");
		hi(new int[] {a[2],a[1],(a[2]+a[1])/2}, new int[]{b[0],b[1],(b[1]+b[2])/2},g);
	
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		new SerpinskiTriangle();
	}
}

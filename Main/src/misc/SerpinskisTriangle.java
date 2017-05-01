package misc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SerpinskisTriangle extends JFrame{

	public SerpinskisTriangle(){
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth =(int) (d.getWidth() / 2.133333);
		int frameHeight =(int) (d.getHeight()-(d.getHeight()/3.5)-45);
		System.out.println(frameWidth + " x " + frameHeight );
		JPanel panel = new JPanel(){ 
			public void paint(Graphics g){
				g.setColor(Color.gray);
				g.fillRect(0, 0, frameWidth, frameHeight);
				g.setColor(Color.GREEN);
				recur(g, frameWidth/7, frameWidth/2, frameWidth-(frameWidth/7), frameHeight-(frameHeight/50), frameHeight/50, frameHeight-(frameHeight/50));
			}

		};
		setVisible(true);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds((int)(d.getWidth()/3.7647), 0, frameWidth, (int) (d.getHeight()-(d.getHeight()/3.5)));
	}
	public void recur(Graphics g, int x1, int x2, int x3, int y1, int y2, int y3){
		g.drawPolygon(new int[]{x1 + ((x3-x1)/2), x2 + ((x3-x2)/2), x3}, new int[]{y1, y2 + ((y3-y2)/2), y3}, 3);
		g.drawPolygon(new int[]{x1 + ((x2-x1)/2),x2,x3-((x3-x2)/2)}, new int[]{y1 - ((y1-y2)/2), y2, y3 - ((y3-y2)/2)}, 3);
		g.drawPolygon(new int[]{x1, x2-((x2-x1)/2), x3-((x3-x1)/2)}, new int[]{y1, y1-((y1-y2)/2), y3}, 3);
		if(x3-x1 <= 20){
			return;
		}
		else{
			recur(g, x1 + ((x3-x1)/2), x2 + ((x3-x2)/2), x3, y1, y2 + ((y3-y2)/2), y3);
			recur(g, x1 + ((x2-x1)/2), x2, x3-((x3-x2)/2), y1 - ((y1-y2)/2), y2, y3 - ((y3-y2)/2));
			recur(g, x1, x2-((x2-x1)/2), x3-((x3-x1)/2), y1, y1-((y1-y2)/2), y3);
		}
	}
	public static void main(String[] args) {
		new SerpinskisTriangle();
	}

}

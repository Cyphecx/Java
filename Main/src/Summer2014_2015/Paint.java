package Summer2014_2015;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Paint extends JFrame implements MouseListener, MouseMotionListener,KeyListener{
	boolean press=false;
	String shape="circle";
	int mousex;
	int mousey;
	int brush=10;
	int color;
	boolean reset=true;
	boolean draging=false;
	int drawx;
	int drawy;
	int drawl;
	int drawh;
	public final static int NUL=0;
	//JColorChooser choose = new JColorChooser();
	Color clr = (Color.white);
	public static void main(String[] args) {
		new Paint();
	}
	public void paint(Graphics g){
		while(brush>999){
			brush=Integer.parseInt(JOptionPane.showInputDialog("Too Large. Try Again"));
		}
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1440, 100);
		g.setColor(clr);
		g.fillRect( 20, 33, 50, 50);
		g.setColor(Color.CYAN);
		g.fillRect(1323, 28, 100, 10);
		g.fillRect(1323, 38, 100, 10);
		g.fillRect(1323, 53, 100, 10);
		g.fillRect(1323, 68, 100, 10);
		g.fillRect(1323, 78, 100, 10);
		g.setColor(Color.black);
		g.drawRect(1323, 28, 100, 10);
		g.drawRect(1323, 38, 100, 10);
		g.drawRect(1323, 53, 100, 10);
		g.drawRect(1323, 68, 100, 10);
		g.drawRect(1323, 78, 100, 10);
		g.setColor(Color.white);
		g.fillRect( 130, 33, 50, 50);
		g.fillRect( 185, 33, 50, 50);
		g.fillRect( 240, 33, 50, 50);
		g.fillRect( 295, 33, 50, 50);
		g.fillRect( 350, 33, 50, 50);
		g.fillRect( 405, 33, 50, 50);
		g.fillRect( 460, 33, 50, 50);
		g.setColor(Color.black);
		g.drawRect( 460, 33, 50, 50);
		g.drawRect( 295, 33, 50, 50);
		g.drawRect( 350, 33, 50, 50);
		g.drawRect( 405, 33, 50, 50);
		g.drawOval( 367, 50, 25, 25);
		g.drawPolygon(new int[]{419,442,421,442},new int[]{53,53,80,80},4);
		g.drawPolygon(new int[]{475,475,503,503},new int[]{77,52,77,52},4);
		g.setFont(new Font("Times New Roman", Font.PLAIN,10));
		g.drawString("+1",1368, 37);
		g.drawString("+5",1368, 47);
		g.drawString("Enter Font",1353, 62);
		g.drawString("-5",1368, 77);
		g.drawString("-1",1368, 87);
		g.drawRect(254, 52, 20, 20);
		g.setColor(Color.red);
		g.drawLine(254, 42, 254, 62);
		g.drawLine(244, 52, 264, 52);
		g.drawLine(309, 42, 309, 62);
		g.drawLine(299, 52, 319, 52);
		g.drawLine(364, 42, 364, 62);
		g.drawLine(354, 52, 374, 52);
		g.drawLine(419, 42, 419, 62);
		g.drawLine(409, 52, 429, 52);
		g.drawLine(474, 42, 474, 62);
		g.drawLine(464, 52, 484, 52);
		g.setColor(Color.black);
		g.drawLine(316, 58, 337, 74);
		g.drawRect( 240, 33, 50, 50);
		g.drawOval( 195, 43, 30, 30);
		g.drawRect( 185, 33, 50, 50);
		g.drawRect( 130, 33, 50, 50);
		g.drawRect( 135, 48, 40, 20);
		g.drawRect( 20, 33, 50, 50);
		g.setFont(new Font("Times New Roman", Font.PLAIN,20));
		g.setFont(new Font("Times New Roman", Font.PLAIN,40));
		g.drawString(""+brush, 1253, 73);
		g.setColor(clr);
		if(press){
			if(shape.equals("circle")){
				g.fillOval(mousex-(brush/2), mousey-(brush/2), brush,brush);
			}
			if(shape.equals("rectangle")){
				g.fillRect(mousex, mousey, brush,brush/2);
			}
			if(shape.equals("rectangleb")){
				g.fillPolygon(new int[]{drawx,drawl,drawl,drawx},new int[]{drawy,drawy,drawh,drawh},4);
				drawx=NUL;
				drawy=NUL;
				drawl=NUL;
				drawh=NUL;
			}
			if(shape.equals("hg")){
				g.fillPolygon(new int[]{drawl,drawx,drawl,drawx},new int[]{drawh,drawh,drawy,drawy},4);
				drawx=NUL;
				drawy=NUL;
				drawl=NUL;
				drawh=NUL;
			}
			if(shape.equals("hgi")){
				g.fillPolygon(new int[]{drawx,drawx,drawl,drawl},new int[]{drawy,drawh,drawy,drawh},4);
				drawx=NUL;
				drawy=NUL;
				drawl=NUL;
				drawh=NUL;
			}
			if(shape.equals("lineb")){
				g.drawLine(drawx, drawy, drawl, drawh);
				drawx=NUL;
				drawy=NUL;
				drawl=NUL;
				drawh=NUL;
			}
			if(shape.equals("circleb")){
				if(drawl<drawx&&drawh<drawy){
					g.fillOval(drawl,drawh,drawx-drawl,drawy-drawh);
				}
				else if(drawl<drawx){
					g.fillOval(drawl,drawy,drawx-drawl,drawh-drawy);
				}
				else if(drawy>drawh){
					g.fillOval(drawx,drawh,drawl-drawx,drawy-drawh);
					p.pl("top right");
				}
				else{
					g.fillOval(drawx,drawy, drawl-drawx, drawh-drawy);
					p.pl("bottom right");
				}
			}
		}

		//drawn=true;
	}
	public Paint(){
		//start=System.currentTimeMillis();
		repaint();
		setTitle("Paint:Spoops");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1440, 820);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setResizable(false);
		repaint();
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(mousex<1423&&mousex>1323&&mousey<38&&mousey>28&&brush<999){
			brush++;
		}
		if(mousex<1423&&mousex>1323&&mousey<58&&mousey>38&&brush<995){
			brush=brush+5;
		}
		if(mousex<1423&&mousex>1323&&mousey<63&&mousey>53&&brush<995){
			brush=Integer.parseInt(JOptionPane.showInputDialog("Enter brush size"));
		}
		if(mousex<1423&&mousex>1323&&mousey<78&&mousey>68&&brush>5){
			brush=brush-5;
		}
		if(mousex<1423&&mousex>1323&&mousey<88&&mousey>78&&brush>1){
			brush--;
		}
		if(mousex<185&&mousex>130&&mousey<83&&mousey>33){
			shape="rectangle";
		}
		if(mousex<240&&mousex>190&&mousey<83&&mousey>33){
			shape="circle";
		}
		//g.fillRect( 240, 33, 50, 50);
		if(mousex<295&&mousex>245&&mousey<83&&mousey>33){
			shape="rectangleb";
		}
		if(mousex<350&&mousex>295&&mousey<83&&mousey>33){
			shape="lineb";
		}
		if(mousex<400&&mousex>350&&mousey<83&&mousey>33){
			shape="circleb";
		}
		if(mousex<455&&mousex>405&&mousey<83&&mousey>33){
			shape="hg";
		}
		if(mousex<510&&mousex>460&&mousey<83&&mousey>33){
			shape="hgi";
		}
		if(mousex<70&&mousex>20&&mousey<83&&mousey>33){
			clr=JColorChooser.showDialog(this, "Choose an Initial Color",Color.BLACK);
			repaint();
		}
		if(mousey>100&&!shape.equals("lineb")){
			press=true;
		}
		else{
			press=false;
		}	repaint();
		if((shape.equals("rectangleb")||shape.equals("lineb")||shape.equals("circleb")||shape.equals("hg")||shape.equals("hgi"))&&mousey>100){
			drawx=e.getPoint().x;
			drawy=e.getPoint().y;
			press=false;
			
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if((shape.equals("rectangleb")||shape.equals("lineb")||shape.equals("circleb")||shape.equals("hg")||shape.equals("hgi"))&&mousey>100){
			drawl=e.getPoint().x;
			drawh=e.getPoint().y;
			press=true;
		}
		else{
			press=false;
			}repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {


	}
	@Override
	public void mouseExited(MouseEvent e) {


	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(mousey>100){
			repaint();
			mousex=e.getPoint().x;
			mousey=e.getPoint().y;
		}
		else{
			press=false;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		//if(drawn){
		mousex=e.getPoint().x;
		mousey=e.getPoint().y;
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_O){
			p.pl(mousex+","+mousey);
		}
		if(e.getKeyCode()==KeyEvent.VK_H){
			p.pl(shape);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

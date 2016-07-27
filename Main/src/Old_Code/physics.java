package Old_Code;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class physics extends JFrame{
	long time;
	long p=System.currentTimeMillis();
	long f=System.currentTimeMillis();
	public int variable1 = 800;
	public int variable2 = 695;
	public int variable = 0;
	private int a2=0;
	private int a=0;
	private int ua=0;
	private boolean jump;
	private boolean right;
	private boolean left;
	private String lastd="";
	private boolean d;
	boolean startup=true;
	private ImageIcon character = new ImageIcon("CharacterIdle.png");
	int i=0;
	int b=0;
	private ImageIcon background = new ImageIcon("Rainbow.jpg");

	JPanel panel = new JPanel(){
		public void paint(Graphics g){
			if(startup){
				Collectibles.Spawn(this, g);
				startup=false;
			}
			background.paintIcon(this, g, variable%1440-1440, 0);
			background.paintIcon(this, g, variable%1440, 0);
			background.paintIcon(this, g, variable%1440+1440, 0);
			if(right){
				lastd="right";
				character = new ImageIcon("CharacterRun"+i+".png");
				if(i==9){
					i=0;
				}
				else
					i++;
			}
			else if(lastd.equals("right")){
				character = new ImageIcon("CharacterIdle.png");
			}
			if(left){
				lastd="left";
				character = new ImageIcon("CharacterRunl"+b+".png");
				if(b==9){
					b=0;
				}
				else
					b++;
			}
			else if(lastd.equals("left")){
				character = new ImageIcon("CharacterIdlel.png");
			}
			character.paintIcon(this, g, variable2, variable1);
			/*if(!right|!left){
				time=f-p;
				if(time>=5000){
					if(!right|!left){
						idle(g);
						
					}
				}
			}*/
		}
	};
	/*public void idle(Graphics g){
		character = new ImageIcon("CharacterIdle0.png");
		character.paintIcon(this, g, variable2, variable1);
		panel.repaint();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			character = new ImageIcon("CharacterIdle1.png");
			character.paintIcon(this, g, variable2, variable1);
			panel.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			character = new ImageIcon("CharacterIdle2.png");
			character.paintIcon(this, g, variable2, variable1);
			panel.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	*/
	public static void main(String[] args) throws InterruptedException {
		new physics();
	}
	public physics() throws InterruptedException{;
	add(panel);
	setTitle("SpoopS");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setSize(1440, 900);
	addKeyListener(new KeyListener(){

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_UP&&variable1==800){
				jump=true; 
			}
			if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
				right=true;
				left=false;
				d=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
				if(variable<=0)
					left=true;
				right=false;
				d=false;
			}
			if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE)
				System.exit(0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
				right=false;
				left=false;
				d=true;
				p=System.currentTimeMillis();
			}
			if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
				left=false;
				right=false;
				d=true;
				p=System.currentTimeMillis();
			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	});
	setVisible(true);
	while(true){

		if(left){
			right();
		}
		if(left&&variable<=0&variable>=-50){
			leftc();
		}
		if(right&&variable2>=695){
			left();
		}
		if(right&&variable2<695){
			rightc();
		}
		if(d){
			decelerate();
		}
		if(d&variable2<695){
			deceleratec();
		}
		if(jump){
			ua=-33;
			jump=false;
		}
		variable1=variable1+ua;
		if(variable1<800){
			ua=ua+3;
		}
		else{
			ua=0;
		}
		if((variable<=-40|a<0)&variable2>=695){
			variable=variable+a;
			//System.out.println(a);
		}
		if(variable2>695){
			variable2=695;
		}
		if(variable2>=0&variable2<=695&variable<=0&variable>=-50){
			variable2=variable2+a2;
		}
		if(variable2<0){
			variable2=0;
		}
		/*if(variable2>695){
			variable2=695;
		}*/
		System.out.println(variable1);
		Thread.sleep(25);
		 f=System.currentTimeMillis();
		panel.repaint();
	}
	}
	public void left(){
		//System.out.println("left "+a);
		if(a>0){
			a-=10;
		}
		if(a>=-25&&a<=0){
			a=a-2;
		}
	}
	public void leftc(){
		if(a2>0){
			a2-=5;
		}
		if(a2>=-25&&a2<=0){
			a2=a2-1;
		}
		System.out.println(a2);
	}
	public void right(){
		//System.out.println("right "+a);
		if(variable<0){
			if(a<0){
				a+=10;
			}
			if(a<=25&&a>=0){
				a=a+2;
			}
		}
		if(a2>0){
			a2-=5;
		}
		if(a2>=-25&&a2<=0){
			a2=a2-1;
		}
		//System.out.println(a2);

	}
	public void rightc(){
		//System.out.println("right "+a2);
		if(a2<0){
			a2+=5;
		}
		if(a2<=25&&a2>=0){
			a2=a2+1;
		}
		if(a>0){
			a-=5;
		}
		if(a>=-25&&a<=0){
			a=a-1;
		}
	}
	public void decelerate(){
		if(a>0){
			a=a-2;
			if(a<0){
				a=0;
			}
		}
		if(a<0){
			a=a+2;
			if(a>0){
				a=0;
			}
		}
		//System.out.println("de "+a);

	}
	public void deceleratec(){
		if(a2>0){
			a2=a2-2;
			if(a2<0){
				a2=0;
			}
		}
		if(a2<0){
			a2=a2+2;
			if(a2>0){
				a2=0;
			}
		}
		//System.out.println("dec "+a2);

	}
}	
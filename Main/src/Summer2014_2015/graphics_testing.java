package Summer2014_2015;
import java.awt.*; 
import javax.swing.*; 
import java.awt.geom.*; 

public class graphics_testing extends JFrame { 
  public graphics_testing() { 
     super("circle"); 
     setSize(410, 435); 
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     Panel sp = new Panel(); 
     Container content = getContentPane(); 
     content.add(sp); 
     setContentPane(content); 
     setVisible(true); 
 } 

 public static void main (String args[]){
  graphics_testing sign = new graphics_testing(); 
 } 
} 

class Panel extends JPanel { 
 public void paintComponent(Graphics comp) { 
     super.paintComponent(comp); 
     Graphics2D comp2D = (Graphics2D) comp; 

     comp2D.setColor(Color.blue); 
     Ellipse2D.Float sign1 = new Ellipse2D.Float(0F, 0F, 350F, 350F); 
     comp2D.fill(sign1); 
 } 
}
package Old_Code;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;


public class rabbit {
	public static void main(String[] noGames) throws AWTException{
		Robot robot = new Robot();
		for(int x=0; x<10000000; x++){
			
		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		}
	}
}

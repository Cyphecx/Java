package bidoof_Platformer;

import java.io.IOException;
import java.util.ArrayList;

public class testLvl {
	public static void main(String[] args) throws IOException {
		LevelInterpreter interp = new LevelInterpreter("resources/platformer/level.lvl");
		ArrayList<ArrayList> level = interp.levels();
		interp.printLevel(level);
	}
}
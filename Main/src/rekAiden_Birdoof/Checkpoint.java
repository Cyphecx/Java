package rekAiden_Birdoof;

public class Checkpoint extends Tile{
	private int spawnX;
	private int spawnY;
	public Checkpoint(int state, int w, int h, int x, int y, int spawnX, int spawnY) {
		super(state, w, h, x, y);
		this.spawnX = spawnX;
		this.spawnY = spawnY;
	}
	public int getSpawnX() {
		return spawnX;
	}
	public int getSpawnY() {
		return spawnY;
	}
	
}

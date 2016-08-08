package maze;
import java.util.ArrayList;

import maze.Direction;
import maze.Maze;

public class IndianaJones {
	static Maze mazee;
	static boolean[][] quack;
	static int[] player=null;
	public static void main(String[] args){
		mazee=new Maze();
		player=mazee.getPiece();
		quack =mazee.getMaze();
		//System.out.println(mazee.getPiece());
		Direction dir=null;
		ArrayList<ArrayList> list=new ArrayList<ArrayList>();
		nav(Direction.RIGHT);
	}
	public static String nav(Direction last){
		int ctr=0;
		ArrayList larva=new ArrayList();
		boolean left=false;
		boolean	right=false;
		boolean	up=false;
		boolean down=false;
		while(ctr<=1){
			ctr=0;
			left=false;
			right=false;
			up=false;
			down=false;
			System.out.println(left+" L, "+right+" R, "+up+" U,"+down+" D ");
			player=mazee.getPiece();
			System.out.println(last);
			if(mazee.foundGoal()){
				return "Woot";
			}
			if(!last.equals(Direction.UP)){
				if(quack[player[0]][player[1]+1]==true){
					down=true;
					ctr++;
				}
			}
			if(!last.equals(Direction.DOWN)){
				if(quack[player[0]][player[1]-1]==true){
					up=true;
					ctr++;
				}
			}
			if(!last.equals(Direction.LEFT)){
				if(quack[player[0]+1][player[1]]==true){
					right=true;
					ctr++;
				}

			}
			if(!last.equals(Direction.RIGHT)){
				if(quack[player[0]-1][player[1]]==true){
					left=true;
					ctr++;
				}
			}
			if(ctr==1){
				if(left){
					try {
						mazee.movePiece(Direction.LEFT);
						larva.add("left");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					last=Direction.LEFT;
				}
				if(right){
					try {
						mazee.movePiece(Direction.RIGHT);
						larva.add("right");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					last=Direction.RIGHT;
				}
				if(up){
					try {
						mazee.movePiece(Direction.UP);
						larva.add("up");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					last=Direction.UP;
				}


				if(down){
					try {
						mazee.movePiece(Direction.DOWN);
						larva.add("down");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					last=Direction.DOWN;
				}

			}
			if(ctr==0){
				System.out.println("dsa");
				for(int i=larva.size()-1; i>-1; i--){
					System.out.println(larva.get(i));
				}
				for(int i=larva.size()-1; i>-1; i--){
					System.out.println("Backing Up");
					if(larva.get(i)=="left"){
						try {
							mazee.movePiece(Direction.RIGHT);
							last=Direction.RIGHT;
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					if(larva.get(i)=="right"){
						try {
							mazee.movePiece(Direction.LEFT);
							last=Direction.LEFT;
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					if(larva.get(i)=="up"){
						try {
							mazee.movePiece(Direction.DOWN);
							last=Direction.DOWN;
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					if(larva.get(i)=="down"){
						try {
							mazee.movePiece(Direction.UP);
							last=Direction.UP;
						} catch (Exception e){
							e.printStackTrace();
						}
					}
					if(last==Direction.UP){
						up=false;
					}
					if(last==Direction.DOWN){
						down=false;
					}
					if(last==Direction.LEFT){
						left=false;
					}
					if(last==Direction.RIGHT){
						right=false;
					}
					
					larva.clear();
					System.out.println("d");
					return "";
				}
			
			}
			System.out.println(ctr);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

		System.out.println(left+" L, "+right+" R, "+up+" U,"+down+" D "+"oussfh;osafd;hofdaasdh;lkads");
		if(up){
			try {
				mazee.movePiece(Direction.UP);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			nav(Direction.UP);
		}
		if(down){
			try {
				mazee.movePiece(Direction.DOWN);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			nav(Direction.DOWN);
		}
		if(left){
			try {
				mazee.movePiece(Direction.LEFT);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			nav(Direction.LEFT);
		}
		if(right){
			try {
				mazee.movePiece(Direction.RIGHT);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			nav(Direction.RIGHT);
		}

		System.out.println("jds");
		return null;
	}

}

//Gayashan K.L
//Y2S1-Batch4



//Main class....................................................
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws SoundException {
		
		Scanner sc = new Scanner(System.in);
		Hunter myhunter = new Hunter("Maha Deva", "Brown");
		Soldier threeSoldier[] = {new RedSoldier(), new RedSoldier(), new GreenSoldier()};
		Board myboard = new Board("superDot", myhunter, threeSoldier);
		
		System.out.println("Use the keyboard up, down, Left, Right arrow keys to move the hunter");
		myhunter.setxPOS(sc.nextInt());
		myhunter.setyPOS(sc.nextInt());
		myhunter.move(myhunter);
		myhunter.hunt();
		threeSoldier[2].hunt();
	}

}

// Hunter class.............................................

public class Hunter {

	private String name;
	private String color;
	private static int xPOS;
	private static int yPOS;
	
	public int getxPOS() {
		return xPOS;
	}
	public void setxPOS(int xPOS) throws SoundException {
		if(xPOS < 250)
			Hunter.xPOS = xPOS;
		else
			throw new SoundException("Oh oo!!");
	}
	public int getyPOS() {
		return yPOS;
	}
	public void setyPOS(int yPOS) throws SoundException {
		if(xPOS < 360)
			Hunter.yPOS = yPOS;
		else
			throw new SoundException("Oh oo!!");
	}
	
	public Hunter(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public static void init() {

		xPOS = 0; 
		yPOS = 0;
		
	}
	
	public void move(Hunter hunter) {
		
		xPOS = hunter.getxPOS();
		yPOS = hunter.getyPOS();
		System.out.println("Hunter is moving, X:" + xPOS + " Y:" + yPOS);
	
	}
	
	public void hunt() {
		
		System.out.println("Hunting " + Board.getDotType());
		
	}
	
}



public class BlueSoldier extends Soldier {



	public void hunt() {
		
		System.out.println("Killed using a gun");//exception message
		System.out.println("Game over");//exception message
		
	}
	
	public void init() {
		
		int xMin = 0;
		int xMax = 250;
		int yMin = 0;
		int yMax = 360;
		
		xPOS = (int)(Math.random() * (xMax-xMin+1) + xMin); 
		yPOS = (int)(Math.random() * (yMax-yMin+1) + yMin);
		
	
	}

}



public class GreenSoldier extends Soldier {



	public void hunt() {
		
		System.out.println("Killed using a knife");
		System.out.println("Game over");
		
	}
	
	public void init() {
		
		int xMin = 0;
		int xMax = 250;
		int yMin = 0;
		int yMax = 360;
		
		xPOS = (int)(Math.random() * (xMax-xMin+1) + xMin); 
		yPOS = (int)(Math.random() * (yMax-yMin+1) + yMin);
		
	
	}



// Board class....................................
public class Board {
	
	private int numberOfDots = 100;
	private int numberOfSuperDots = 3;
	private static String dotType;
	private Hunter theHunter;
	private Soldier threeSoldier[];
	
	static {
		Hunter.init();
	}
	
	public Board(String dotType, Hunter theHunter, Soldier threeSoldier[]) {
		this.dotType = dotType;
		this.theHunter = theHunter;
		this.threeSoldier = threeSoldier;
		
		initailizeC();
	}
	
	private void initailizeC() {
		
		for(int i=0; i<3; ++i) {
			if(threeSoldier[i] == new RedSoldier()) {
				threeSoldier[i].init();
			} else if(threeSoldier[i] == new GreenSoldier()) {
				threeSoldier[i].init();
			} else {
				threeSoldier[i].init();
			}
		}
		
	}
	
	public static String getDotType( ) {
		return dotType;
	}

}



public abstract class Soldier {
	
	protected int xPOS;
	protected int yPOS;
	Soldier theSoldier[];
	
//	public Soldier(Soldier theSoldier[]) {
//		
//		for(int i=0; i<3; ++i) {
//			this.theSoldier[i] = theSoldier[i];
//		}
//		
//	}
	
	public abstract void hunt();
	
	public abstract void init();

}



public class RedSoldier extends Soldier {



	public void hunt() {
		
		System.out.println("Killed using hand");
		System.out.println("Game over");
		
	}
	
	public void init() {
		
		int xMin = 0;
		int xMax = 250;
		int yMin = 0;
		int yMax = 360;
		
		xPOS = (int)(Math.random() * (xMax-xMin+1) + xMin); 
		yPOS = (int)(Math.random() * (yMax-yMin+1) + yMin);
		
	
	}

}





@SuppressWarnings("serial")
public class SoundException extends Exception {

	public SoundException(String playSound) {
		super(playSound);  //exception sound
	}
	
}

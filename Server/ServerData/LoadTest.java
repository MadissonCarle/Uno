package Server.ServerData;

import javax.swing.JFrame;


public class LoadTest {
	GameDeck gd;
	JFrame frame = new JFrame("Testing");
	PlayerDeck pd;

	public static void main(String[] args) {
		LoadTest lt = new LoadTest();
		lt.frame.add(lt.pd);
		lt.frame.add(lt.gd); // this pane is on top of the other
		//try limiting boundaries for each pane so they do not cover each other
		// (player deck at the bottom while game deck is in the middle)
		lt.frame.setVisible(true);
		
		  
	}
	 public LoadTest() {
	      frame.setSize(1600,1000);
	      gd = new GameDeck();
	      gd.loadImage();
	      pd = new PlayerDeck(gd);
	      pd.initDeck();
	      pd.displayDeck();
	      gd.displayGameDeck();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                
	 }

}

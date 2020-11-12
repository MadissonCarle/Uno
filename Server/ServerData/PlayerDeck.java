package Server.ServerData;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLayeredPane;

public class PlayerDeck extends JLayeredPane {
	private ArrayList <Card> pCards;
	private GameDeck gDeck;
	
	public PlayerDeck(GameDeck gd) {
		pCards = new ArrayList <Card>();
		gDeck = gd;
		
	}
	
	public void  initDeck() {
		//pick 7 random cards from gDeck cards, put the card in player's cards, remove that card from gDeck
		Collections.shuffle(gDeck.getCards());
		for(int i = 0; i < 7; i ++) {
			pCards.add(gDeck.getCards().get(0));
			gDeck.getCards().remove(0);
		}
	}
	
	
	public void displayDeck() {
		//display the current state of the player's deck
		//check phone notes for the distance between cards
		int x = 300;
		int y = 500;
		for(Card c : pCards) {
			c.getFront().setLocation(x, y);
			add(c.getFront());
			x+= 120;
		}
	}
}

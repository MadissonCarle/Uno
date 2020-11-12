package Server.ServerData;

import java.awt.Component;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameDeck extends JLayeredPane {
	
	private ArrayList<Card> cards;
	MouseHandler mh = new MouseHandler();
	
	public GameDeck() {
		cards = new ArrayList<Card>();
	}
	
	//this function loads the front and back image for each card
	public void loadImage() {
		File[] images = new File("D:\\prog\\Java projects\\UNO game\\src\\Asset\\LargeCards").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName().toLowerCase();
                return name.endsWith(".png") || 
                                name.endsWith(".jpg") || 
                                name.endsWith(".bmp") ||
                                name.endsWith(".gif");
            }
        });
		
		try {
		File []backImg = new File("D:\\prog\\Java projects\\UNO game\\src\\Asset").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String name = pathname.getName().toLowerCase();
                return name.endsWith(".png") || 
                                name.endsWith(".jpg") || 
                                name.endsWith(".bmp") ||
                                name.endsWith(".gif");
            }
        });
		BufferedImage back;
		back = ImageIO.read(backImg[0]);
		Image change = back.getScaledInstance(104,146,Image.SCALE_SMOOTH);
		for(File img: images) {
			Card c = new Card(img);
			c.setBack(new JLabel(new ImageIcon(change)));
			c.getBack().setSize(c.getBack().getPreferredSize());
			this.insert(c);
			  
		  }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void displayGameDeck() {
		for(Card c : cards) {
			c.getBack().setLocation(800,300);
			add(c.getBack());
		}
	}
	
	public void insert(Card c) {
		c.getFront().addMouseListener(mh);
		c.getFront().addMouseMotionListener(mh);
		c.getBack().addMouseListener(mh);
		c.getBack().addMouseMotionListener(mh);
		cards.add(c);
		//using the add() function will add an image to the window
	}
	
	class MouseHandler extends MouseAdapter {

        private Point offset;
        
        //when mouse pressed, choose the current image
        @Override
        public void mousePressed(MouseEvent e) {
            moveToFront((JLabel)e.getSource());
            offset = e.getPoint();
        }
        
        //dragging, take current position of mouse and add the difference to the location of the image
        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getPoint().x - offset.x;
            int y = e.getPoint().y - offset.y;
            Component component = e.getComponent();
            Point location = component.getLocation();
            location.x += x;
            location.y += y;
            component.setLocation(location);
        }

    }
	
	public ArrayList<Card> getCards(){
		return this.cards;
	}
}

package Server.ServerData;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Card {
	private BufferedImage image;
	private String color; //color of the card, (red,green,blue,yellow,black)
	private String number; 
	static final int heightS = 70; // height of card to display
	static final int widthS = 52; // width of card to display
	private String function;
	private JLabel front;
	private JLabel back;
	
	//load image for the card image  file
	public Card(File imgFile) {
		String name = imgFile.toString();
		getInfo(name);
            try {
                image = ImageIO.read(imgFile);
                Image change = image.getScaledInstance(104,146,Image.SCALE_SMOOTH);
                front = new JLabel(new ImageIcon(change));
                front.setSize(front.getPreferredSize());
            } catch (IOException exp) {
                exp.printStackTrace();
            }

    }
	
	//extract info from the file name
	private void getInfo(String name) {
		String[] info = name.replaceAll("[^0-9a-zA-Z ]", " ").split("\\s+"); 
		color = info[0];
		if(isNumber(info[1])) {
			number = info[1];
		}
		else
			function = info[1];
	}
	
	//helper function for getInfo
	private boolean isNumber(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	//private void draw
	
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public JLabel getFront() {
		return front;
	}

	public void setFront(JLabel front) {
		this.front = front;
	}

	public JLabel getBack() {
		return back;
	}

	public void setBack(JLabel back) {
		this.back = back;
	}
	
}

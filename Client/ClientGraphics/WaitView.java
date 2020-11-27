package Client.ClientGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitView extends JFrame{

	private JLabel [] players;
	private JButton quit = new JButton("Back");
	private JButton start = new JButton("Start!");
	public WaitView(String[]player) {
		super("UNO Simulator");
		try {
		setSize(1000,1000);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		players= new JLabel[player.length];
		
		//background image panel
		BufferedImage back= ImageIO.read(new File("D:\\prog\\Java projects\\UNO game\\src\\Asset\\waiting.png"));
		JLabel label = new JLabel(new ImageIcon(back));
		label.setSize(100, 1000);
		label.setLocation(0,0);
		JPanel panel4=new JPanel();
		panel4.add(label);
		
		JPanel panel5= new JPanel();
		panel5.setBackground(new Color(187, 228, 252));
		panel5.setSize(300, 400);
		for(int i=0;i<player.length;i++) {
			players[i]=new JLabel(player[i]);
			players[i].setOpaque(false);
			players[i].setBounds(150, 175+(i*50), 300, 50);
			panel5.add(players[i]);
		}
		
		start.setBounds(110, 700, 150, 50);
		add(start);
		quit.setBounds(330, 700, 150, 50);
		add(quit);
		
		panel5.setBounds(130,175,300,400);
		add(panel5);
		panel4.setBounds(0,0,1000,1000);
		add(panel4);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 
		}catch(IOException exp) {
				exp.printStackTrace();
		}
	}
	
	public static void main(String []args) {
		String []a= {"a"};
		String []b= {"b"};
		WaitView mv=new WaitView(a);
		
	}
}

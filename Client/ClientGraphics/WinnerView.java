package Client.ClientGraphics;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinnerView extends JFrame{

	private JButton quit = new JButton("Quit");
	private JButton game = new JButton("Create New Game");
	public WinnerView() {
		super("UNO Simulator");
		setSize(600,500);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(187, 228, 252));
		

		//background image panel
		Icon icon = new ImageIcon("D:\\prog\\Java projects\\UNO game\\src\\Asset\\Winner2.gif");
        try {
            this.setContentPane(new JLabel(icon));
            
        } catch (Exception e) {
        }
        
        JPanel panel1= new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setBackground(new Color(187, 228, 252));
        panel1.add(quit,BorderLayout.EAST);
        panel1.add(game,BorderLayout.WEST);
        panel1.setBounds(0, 425, 600, 50);
        add(panel1);
        
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
	
	public static void main(String []args) {
		WinnerView wv=new WinnerView();
		
	}
}
	

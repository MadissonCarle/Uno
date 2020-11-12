package Client.ClientGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * What users see when they start the game, they can choose to either create or start a game
 * @author 
 *
 */
public class LoginView extends JFrame{
	
	private JButton create = new JButton("Create A Game");
	private JButton join = new JButton("Join A Game");
	private JLabel select = new JLabel("Please select an option");
	private JLabel pass= new JLabel("Enter/Create the game password");
	private JLabel user=new JLabel("Enter your player name");
	private JLabel game=new JLabel("Enter/Create the game name");
	private JTextField userText = new JTextField (10);
	private JTextField passText= new JTextField(10);
	private JTextField gameText = new JTextField (10);
	private JLabel welcome = new JLabel("Welcome to online UNO!");
	private JLabel instruction1 = new JLabel("If you are creating a new game, enter your own game name and password and share it with friends!");
	private JLabel instruction2 = new JLabel("If you are joining a game enter the game name and password provided by your friends!");
	
	public LoginView() {
		
		super("UNO Simulator");
		setSize(1000,700);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBackground(Color.red);
		
		//panel for create and join
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(user);
		panel1.add(userText);
		//password panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(pass);
		panel2.add(passText);
		
		JPanel panel3 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(game);
		panel1.add(gameText);
		
		welcome.setBounds(425, 100, 300, 40);
		add(welcome);
		instruction1.setBounds(200, 150, 600, 40);
		add(instruction1);
		instruction2.setBounds(225, 175, 600, 40);
		add(instruction2);
		//buttons
		select.setBounds(425, 450, 350, 40);
		add(select);
		create.setBounds(200, 500, 150, 40);
		add(create);
		join.setBounds(600, 500, 150, 40);
		add(join);
		
		panel1.setBounds(300, 300, 350, 50);
		add(panel1);
		panel2.setBounds(300, 350, 350, 50);
		add(panel2);
		panel3.setBounds(300, 400, 350, 50);
		add(panel3);
		
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}

	

	public JLabel getSelect() {
		return select;
	}



	public void setSelect(JLabel select) {
		this.select = select;
	}



	public JLabel getPass() {
		return pass;
	}



	public void setPass(JLabel pass) {
		this.pass = pass;
	}



	public JLabel getUser() {
		return user;
	}



	public void setUser(JLabel user) {
		this.user = user;
	}



	public JTextField getUserText() {
		return userText;
	}



	public void setUserText(JTextField userText) {
		this.userText = userText;
	}



	public JTextField getPassText() {
		return passText;
	}



	public void setPassText(JTextField passText) {
		this.passText = passText;
	}



	public JButton getJoin() {
		return join;
	}

	public void setJoin(JButton join) {
		this.join = join;
	}

	public JButton getCreate() {
		return create;
	}

	public void setCreate(JButton create) {
		this.create = create;
	}
	
	
	public static void main(String []args) {
		LoginView lv=new LoginView();
		lv.setVisible(true);
	}
}

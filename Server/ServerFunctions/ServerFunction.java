package Server.ServerFunctions;

import Server.ServerData.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server that runs the game
 * @author

 */
public class ServerFunction implements Runnable{
	private Socket socket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	

	/**
	 * Constructs a ServerFunction object that handles request from a client
	 */
	public ServerFunction(Socket clientSocket) {
		try {
			//serverSocket = new ServerSocket(port);
			socket = clientSocket;
			setSocketIn(new BufferedReader(new InputStreamReader(socket.getInputStream())));
			setSocketOut(new PrintWriter(socket.getOutputStream(), true));

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		try {
			function();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Runs the server and communicates with Client
	 * @throws IOException the input output exception for sockets
	 */
	public void function() throws IOException{
		String input = "";
		boolean running = true;
		while(running) {
			try {
				input = socketIn.readLine();
				if(input != null && !input.equals("quit")) {
					System.out.println(input);
					menu(input);
				}
				else if(input.equals("quit")) {
					System.out.println("Server shutting down");
					running = false;
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Represents a menu that calls different functions based on user selection
	 * @param action the action that the Client chose 
	 */
	public void menu(String action) {
		String[] instruction = action.replaceAll("[^0-9a-zA-Z ]", " ").split("\\s+"); 
		/*
        switch(instruction[0]) {
        case "cata":
        	System.out.println("cata received");
            searchCat(instruction[1],instruction[2]);
            break;
        case "addC":
        	System.out.println("addC received");
            addStudCourse(instruction[1],instruction[2],instruction[3]);
            break;
        case "removeC":
        	System.out.println("removeC received");
            removeStudCourse(instruction[1],instruction[2],instruction[3]);
            break;
        case "printCat":
        	System.out.println("printCat received");
            printCat();
            break;
        case "printStud":
        	System.out.println("printStud received");
            printStudCourse();
            break;
        case "login":
        	System.out.println("login received");
        	login(instruction[1], instruction[2]);
        	break;
        	
        default:
            System.out.println("invalid input, try again");
            break;

        }
*/
	}
	

	
	/**
	 * Gets socket
	 * @return socket
	 */
	public Socket getSocket() {
		return socket;
	}
	
	/**
	 * Sets socket to parameter
	 * @param s the Socket
	 */
	public void setSocket(Socket s) {
		this.socket = s;
	}

	/**
	 * Gets socketOut
	 * @return socketOut
	 */
	public PrintWriter getSocketOut() {
		return socketOut;
	}

	/**
	 * Sets socketOut to parameter
	 * @param socketOut the Socket Output Stream
	 */
	public void setSocketOut(PrintWriter socketOut) {
		this.socketOut = socketOut;
	}

	/**
	 * Gets socketIn
	 * @return socketIn
	 */
	public BufferedReader getSocketIn() {
		return socketIn;
	}

	/**
	 * Sets socketIn to parameter
	 * @param socketIn the Socket input Stream
	 */
	public void setSocketIn(BufferedReader socketIn) {
		this.socketIn = socketIn;
	}

	
	
}


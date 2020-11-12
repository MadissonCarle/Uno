package Server.ServerFunctions;
import java.io.IOException;
import java.net.InetAddress;
//server runner creates a server at port number and constantly looks for new connections(clients)
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Run the Server
 */
public class ServerRunner {
	private Socket socket;
	private ServerSocket serverSocket;
	private ExecutorService pool;
	
	
	/**
	 * Constructs a ServerRunner object
	 * @param portNumber the port number
	 */
	public ServerRunner(int portNumber) {
		try {
			serverSocket = new ServerSocket(portNumber);
			pool = Executors.newCachedThreadPool();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Communicates with the Client
	 */
	public void communicate() {
		try{
			while(true) {
				socket = serverSocket.accept();
				//pool.execute(sc);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main (String [] args){
	
		ServerRunner sv = new ServerRunner(8099);
		System.out.println("Server is running");
		
		sv.communicate();

	}
}

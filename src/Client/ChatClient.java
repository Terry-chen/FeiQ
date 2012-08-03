package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient {
	private Socket connectToServer;
	private ObjectInputStream inMessageStream;
	private ObjectOutputStream outMessageStream;
	
	
	public ChatClient(){
		try{
			//System.out.println("Please enter your Username:");
			connectToServer = new Socket("localhost",2345);
			System.out.println("hello1!!");
			//inMessageStream = new ObjectInputStream(connectToServer.getInputStream());
			System.out.println("hello2!!");
			outMessageStream = new ObjectOutputStream(connectToServer.getOutputStream());
			System.out.println("hello3!!");
			
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter your Username:");
			String outStr =buf.readLine();
			outMessageStream.writeUTF(outStr);
			outMessageStream.flush();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		new ChatClient();
	}
}

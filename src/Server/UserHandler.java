package Server;

import Server.ChatServerConnectionHandler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserHandler implements Runnable{
private String username;
private Socket userSocket;
private ChatServerConnectionHandler serverConnectionHandler;
private ObjectInputStream inMessageStream;
private ObjectOutputStream outMessageStream;

public UserHandler(Socket socket,ChatServerConnectionHandler handler){
	this.userSocket = socket;
	this.serverConnectionHandler = handler;
	try{
		inMessageStream = new ObjectInputStream(socket.getInputStream());
		outMessageStream = new ObjectOutputStream(socket.getOutputStream());
		outMessageStream.flush();
	}catch(Exception ex){
		ex.printStackTrace();
	}
	
	
}
public void run(){
	try{
		username = (String)inMessageStream.readObject();
		if(username == "sgamerv" || username == "terry"){
			outMessageStream.writeUTF("Login Successful!!");
			outMessageStream.flush();
			System.out.println(username+" login successful!!");
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
}
}

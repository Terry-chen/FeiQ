package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import Server.UserHandler;

/**Server端连接处理类
 * 
 * @author Sgamerv
 *
 */
public class ChatServerConnectionHandler 
{
	public final int SERVER_PORT = 2345;
	public final int MAX_QUEUED_CONNECTION = 10;
	private ServerSocket serverSocket;
	
	public void startListenFromConnection(){
		try{
			serverSocket = new  ServerSocket(SERVER_PORT,MAX_QUEUED_CONNECTION);
			serverSocket.setSoTimeout(2000);
			System.out.println("New Server socket create on port:"+MAX_QUEUED_CONNECTION);
			
			while(true){
				try{
					Socket userSocket = serverSocket.accept();
					System.out.println("Come from:"+userSocket.getInetAddress().getHostAddress());
					UserHandler userHandler = new UserHandler(userSocket,this);
					(new Thread(userHandler)).start();
					
				}catch(SocketTimeoutException ex){
					
				}
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}

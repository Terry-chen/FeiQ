package Server;
import Server.ChatServerConnectionHandler;
 
/**入口文件，启动Server
 * 
 * @author Sgamerv
 * @version 1.0
 */
public class ChatServer {
public static void main(String args[]){
	ChatServerConnectionHandler connectionHandler = new ChatServerConnectionHandler();
	connectionHandler.startListenFromConnection();
}
		
}

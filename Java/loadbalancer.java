import java.io.*;
import java.net.*;

public class loadbalancer{
		public static void main(String []args)throws IOException{
		ServerSocket s1=new ServerSocket(1234);
		while(true){
			Socket connsocket=s1.accept();
			BufferedReader messagefromclient=new BufferedReader(new InputStreamReader(connsocket.getInputStream()));
			String client_sentence=messagefromclient.readLine();

			if(client_sentence.contains("white")){
			Socket server=new Socket("192.168.17.129",2345);
			DataOutputStream outtoserver=new DataOutputStream(server.getOutputStream());
			outtoserver.writeBytes(client_sentence+"\n");
			server.close();
			}

			else if(client_sentence.contains("black")){
			Socket server2=new Socket("192.168.17.130",2346);
			DataOutputStream outtoserver2=new DataOutputStream(server2.getOutputStream());
			outtoserver2.writeBytes(client_sentence+"\n");
			server2.close();
			}

			else{System.ou.println(ERROR!!);}
			}
		}
}
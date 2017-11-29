import java.io.*;
import java.net.*;

public class server2{
		public static void main(String []args)throws IOException{
		ServerSocket s1=new ServerSocket(2346);
		while(true){
			Socket connsocket=s1.accept();
			BufferedReader messagefromloadbalancer=new BufferedReader(new InputStreamReader(connsocket.getInputStream()));
			String sentence=messagefromloadbalancer.readLine();
			System.out.println("Data received from load balancer: "+sentence);
		}
	}
}
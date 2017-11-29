import java.io.*;
import java.net.*;

public class client{
		public static void main(String []args)throws IOException{
		Socket myjavaclient=new Socket("192.168.80.129",1234);
		DataOutputStream outtoserver=new DataOutputStream(myjavaclient.getOutputStream());
		BufferedReader infromuser=new BufferedReader(new InputStream(System.in));
		String sentence=infromuser.readLine();
		outtoserver.writeBytes(sentence);
		myjavaclient.close();
		}
}
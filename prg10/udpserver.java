package prg10;
import java.io.*;
import java.net.*;
public class udpserver 
{
    public static DatagramSocket serversocket;
    public static DatagramPacket dp;
    public static BufferedReader br; // bufferedReader class - read the text from a character-based input stream
    public static InetAddress ia;
    public static byte buf[] = new byte[1024];
    public static int cport = 3000,sport=8000;
    public static void main(String[] args) throws IOException
    {
        serversocket = new DatagramSocket(sport); //create new socket
        dp = new DatagramPacket(buf,buf.length);
        br = new BufferedReader (new InputStreamReader(System.in)); // entered input stream is read by bufferedReader
        ia = InetAddress.getLocalHost(); // class returns the instance of InetAddress containing local host name and address
        System.out.println("Server is Running...");
        while(true)
        {
            serversocket.receive(dp); // recieves datapkt from client
            String str2 = new String(dp.getData(), 0, dp.getLength()); // get data
            if(str2.equals("exit"))
            {
                System.out.println("Terminated...");
                break;
            }
            System.out.println("Client said : " + str2); // display msg
            String str3 = new String(br.readLine()); // reads line of a text
            buf = str3.getBytes(); // into bytes
            serversocket.send(new DatagramPacket(buf,str3.length(), ia, cport)); // send data packet to client
        }
    }
    
}

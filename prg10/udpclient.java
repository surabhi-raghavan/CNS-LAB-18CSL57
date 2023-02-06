package prg10;
import java.io.*;
import java.net.*;
public class udpclient {
    public static DatagramSocket clientsocket;
    public static DatagramPacket dp;
    public static BufferedReader br;
    public static InetAddress ia;
    public static byte buf[] = new byte[1024];
    public static int cport = 3000, sport = 8000;
    public static void main(String[] args) throws IOException
    {
        clientsocket = new DatagramSocket(cport); //create socket
        dp = new DatagramPacket(buf, buf.length); //data packet
        br = new BufferedReader(new InputStreamReader(System.in));
        ia = InetAddress.getLocalHost();

        System.out.println("Client is Running...");
        System.out.println("Type some text if you want, else 'exit' to quit");
        
        while(true)
        {
            String str1 = new String(br.readLine());
            buf = str1.getBytes(); // string is converted into bytes format
            if(str1.equals("exit")) // data = exit then terminates connection
            {
                System.out.println("Terminated..");
                clientsocket.send(new DatagramPacket(buf,str1.length(),ia,sport));
                break;
            }

            clientsocket.send(new DatagramPacket(buf,str1.length(), ia, sport)); // sends data packet
            clientsocket.receive(dp); //recieves data packet from server
            String str4 = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Server said : " + str4);
        }
    }
}

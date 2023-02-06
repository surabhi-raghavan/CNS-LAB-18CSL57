package prg9;
import java.io.*;
import java.net.*;
import java.util.*;
public class tcpserver {
    public static void main(String args[]) throws Exception
    {
        int data = 1;
        ServerSocket sersock = new ServerSocket(5119);
        
        while(data == 1)
        {
            System.out.println("Server ready for connection....");
            Socket sock = sersock.accept(); 

            System.out.println("Connection Established\nWaiting for Client Request.");
            InputStream istream = sock.getInputStream( );

            BufferedReader br =new BufferedReader(new InputStreamReader(istream));
            String fname = br.readLine();
            if(fname.equals("exit"))
             continue;
            
            BufferedReader contentRead = new BufferedReader(new FileReader(fname));
            OutputStream ostream = sock.getOutputStream( );

            PrintWriter pwrite = new PrintWriter(ostream, true);
            String str;

            while((str = contentRead.readLine()) != null) 
                 pwrite.println(str);
            
            System.out.println("\nFile Contents sent successfully\n\n");
            pwrite.close();
            br.close();
            contentRead.close();
            sock.close();
        }
    }
}
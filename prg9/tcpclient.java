package prg9;
import java.net.*;
import java.io.*;
import java.util.*;

public class tcpclient {
    public static void main(String args[]) throws Exception
    {
        int Entry = 1;
        Scanner sc = new Scanner(System.in);
        String address = "127.0.0.1";

        while (Entry == 1)
        {
            Socket sock = new Socket(address, 5119);

            System.out.println("Enter file name to send. Enter 'exit' to exit");
            System.out.print("Client /> ");
            String Command = sc.nextLine(); 

            if (Command.equals("exit"))
            {
                Entry = 0;
                break;
            }

            OutputStream op = sock.getOutputStream(); //Setting up the output streams
            PrintWriter pwrite = new PrintWriter(op, true);
            pwrite.println(Command);

            InputStream ip = sock.getInputStream();
            BufferedReader socketRead = new BufferedReader(new InputStreamReader(ip));
            String FileContent="";
            String Temp;
            //Reading file till end of content and storing the contents on in FileContent string variable
            while ((Temp = socketRead.readLine()) != null)
            {
                pwrite.println(Temp);
                FileContent+=Temp;
            }
            System.out.println("File : "+Command+" Received.");
            //Setting the name of the file to "Client" + command(user's input-file name)
            FileWriter Writer = new FileWriter("Client"+Command); //argument:new file name
            Writer.write(FileContent); //Writing the filecontents on to the new file
            Writer.close();
            pwrite.close();
            socketRead.close();
            sock.close();
        }
        sc.close();
    }
}
    


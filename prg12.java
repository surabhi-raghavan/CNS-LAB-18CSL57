import java.util.*;
public class prg12 {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the output rate and buffer size: ");
        int op=sc.nextInt();
        int bs=sc.nextInt();
        int cs=0, of=0, rs=0, option=1;

        while(option==1)
        {
            System.out.println("Enter Input Rate: ");
            int ip=sc.nextInt(); 
            rs=cs+ip;
            if(bs<cs+ip)
            {
                of=rs-bs; 
                cs=rs-of-op; 
            }
            else
            {
                of=0; 
                cs+=ip-op; 
            }
            System.out.println("IP Rate: "+ip+"/t Total Storage:"+rs+"\tOverflow: "+of+"\tCurrent Storage: "+cs)
            option=sc.nextInt(); 
        }
        sc.close(); 

    }
}

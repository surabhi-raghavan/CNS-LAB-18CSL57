import java.util.*;
public class prg7 {
    void divide(int []a, int k)
    {
        int count=0;
        int []gp={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1}; 

        for(int i=0;i<k;i++)
        {
            if (a[i]==1)
            {
                for(int j=i;j<17+i;j++)
                    a[j]^=gp[count++]; 
            }
            count=0;
        }
    }

    public static void main(String []args)
    {
        Scanner sc=new Scanner (System.in);
        int []a=new int[100];
        int []b=new int[100]; 

        System.out.println("Enter length of message : ");
        int len=sc.nextInt();

        int k=len; 

        System.out.println("Enter the data bit by bit:");
        for(int i=0;i<len;i++)
            a[i]=sc.nextInt(); 
        
        for(int i=0;i<16;i++)
            a[len++]=0; 
        
        prg7 ob=new prg7(); 

        for(int i=0;i<len;i++)
            b[i]=a[i]; 
        
        ob.divide(a,k);
        for(int i=0;i<len;i++)
            a[i]^=b[i]; 
        
        System.out.println("DATA SENT: ");
        for(int i=0;i<len;i++)
            System.out.print(a[i]+ " ");
        System.out.println();
        
        System.out.println("Enter the data to be transmitted: ");
        for(int i=0;i<len;i++)
            a[i]=sc.nextInt(); 
        
        ob.divide(a, k);
        int flag=0; 
        for(int i=0;i<len;i++)
        {
            if(a[i]!=0)
            {
                flag=1;
                break; 
            }
        }
        if (flag==1)
            System.out.println("Error");
        else 
            System.out.println("No error");
        sc.close(); 
    }
}
    


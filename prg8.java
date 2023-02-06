import java.util.*; 
public class prg8 {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in); 
        int g[][]=new int[100][100];

        System.out.println("Enter the number of nodes: ");
        int n=sc.nextInt(); 

        System.out.println("Enter the Adjacency Matrix: ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                g[i][j]=sc.nextInt(); 
        }
        int []d=new int[n]; 
        System.out.println("Enter the source node: ");
        int src=sc.nextInt(); 
        
        for(int i=0;i<n;i++)
            d[i]=999;
        d[src]=0; 

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(d[k]>d[j]+g[j][k])
                        d[k]=d[j]+g[j][k]; 
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            if(src==i)
            continue;
            System.out.println(src+"-->"+i+": "+ d[i]); 
        }
        sc.close();
    }
    
}

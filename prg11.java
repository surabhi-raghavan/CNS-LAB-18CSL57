import java.util.*; 
import java.math.*; 
public class prg11 {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        BigInteger p,q,n,e,d,phi; 
        int max=1024;
        Random r=new Random(); 

        p=BigInteger.probablePrime(max, r);
        q=BigInteger.probablePrime(max, r); 

        n=p.multiply(q); 
        phi=(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE))); 
        String message=""; 

        e=BigInteger.probablePrime(max/2, r); 
        
        while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
            e.add(BigInteger.ONE); 
        d=e.modInverse(phi); 

        System.out.println("Enter the message: ");
        message=sc.nextLine(); 

        System.out.println("Message to encrypt: "+message);
        
        byte []mess= message.getBytes(); 
        byte []cipher= (new BigInteger(mess)).modPow(e,n).toByteArray();
        
        System.out.println("Cipher Text: "+ new String(cipher));
        
        byte []decipher= (new BigInteger(cipher)).modPow(d,n).toByteArray();
        System.out.println("Decipher Text: "+ new String(decipher));
    }

    
}

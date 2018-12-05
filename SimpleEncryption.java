import java.io.*;

public class SimpleEncryption
{
        public static void main(String ar[])throws Exception
        {
        DataInputStream in=new DataInputStream(System.in);
        FileInputStream fi=new FileInputStream("c:\\pp.txt");
        int key=Integer.parseInt(in.readLine());
        int len=fi.available();
        char ca[]=new char[len];
        int ia[]=new int[len];
     
                for(int i=0;i<len;i++)
                {
                ia[i]=fi.read();
                }
                int a[]=new int[ia.length];
                for(int i=0;i<ia.length;i++)
                {
                 ia[i]=ia[i]-key;
                 a[i]=ia[i];
                 char c=(char)a[i];
                 System.out.print(c);
                }

        }

}

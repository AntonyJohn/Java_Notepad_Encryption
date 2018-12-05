import java.io.*;

class DecryptFile
{
    public static void main(String ar[])throws Exception
    {
    DataInputStream in=new DataInputStream(System.in);
    FileInputStream fis=new FileInputStream("c:\\pp.txt");
    
    System.out.println("Enter The Key");
    String key=in.readLine();
    char ckey[]=new char[key.length()];
    key.getChars(0,key.length(),ckey,0);
    int ikey[]=new int[key.length()];
        for(int i=0;i<key.length();i++)
        {
        int v=Integer.parseInt(ckey[i]+"");
        ikey[i]=v;
        }
       int ascod[]=new int[fis.available()];
    int m=0,a;
    while((a=fis.read())!=-1)
    {
    ascod[m]=a;
    m++;
    }
    System.out.println("Decrypted Format");
        try
        {
            int len=ikey.length;
            int p=0;
            while(p<ascod.length+1)
            {
                for(int i=0;i<len;i++)
                {
                ascod[p]=ascod[p]-ikey[i];
                char c=(char)ascod[p];
                p++;
                System.out.print(c);
                }
           }
        }
        catch(Exception e)
        {}
      }
}

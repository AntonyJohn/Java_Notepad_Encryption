import java.io.*;

class EncryptFile
{
    public static void main(String ar[])throws Exception
    {
    DataInputStream in=new DataInputStream(System.in);
    FileOutputStream out=new FileOutputStream("c:\\pp.txt");
    System.out.println("Enter The Encryption Key");
    String key=in.readLine();
    char ckey[]=new char[key.length()];
    key.getChars(0,key.length(),ckey,0);
    int ikey[]=new int[key.length()];
        for(int i=0;i<key.length();i++)
        {
        int v=Integer.parseInt(ckey[i]+"");
        ikey[i]=v;
        }
    System.out.println("Enter The Text");
    String text=in.readLine();
    char textc[]=new char[text.length()];
    text.getChars(0,text.length(),textc,0);
    int ascod[]=new int[text.length()];
        for(int i=0;i<text.length();i++)
        {
        ascod[i]=(int)textc[i];
        }
    System.out.println("Encrypted Format");

        try
        {
            int len=ikey.length;
            int p=0;
            while(p<text.length())
            {
                for(int i=0;i<len;i++)
                {
                ascod[p]=ascod[p]+ikey[i];
                char c=(char)ascod[p];
                p++;
                out.write(c);
                System.out.print(c);
                }
           }
        }
        catch(Exception e)
        {}
      }
}


import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Notepad extends Frame implements ActionListener
{
Frame f;
TextArea t1;
MenuBar m1;
Menu fi,edit,format;
MenuItem ne,op,sav,ex;
MenuItem cu,cp,pt,sel;
MenuItem font;
MenuShortcut mcu,mcp,mpt,mse;

Font fpl,fbo,fit;
List fon,siz;
TextField fon_t,fon_s;
Button ok,cancel;

Notepad()
{
super("Notepad");
setLayout(new BorderLayout(5,5));

f=new Frame("Font");

t1=new TextArea();
m1=new MenuBar();
fi=new Menu("File");
edit=new Menu("Edit");
format=new Menu("Format");

ne=new MenuItem("New");
op=new MenuItem("open");
sav=new MenuItem("save");
ex=new MenuItem("Exit");

cu=new MenuItem("cut");
cp=new MenuItem("copy");
pt=new MenuItem("paste");
sel=new MenuItem("Select-All");

font=new MenuItem("Font");

fon=new List(4,false);
siz=new List(10,false);

fon_t=new TextField(10);
fon_s=new TextField(10);

ok=new Button("OK");
cancel=new Button("Cancel");

mcu=new MenuShortcut(KeyEvent.VK_X,false);
mcp=new MenuShortcut(KeyEvent.VK_C,false);
mpt=new MenuShortcut(KeyEvent.VK_V,false);
mse=new MenuShortcut(KeyEvent.VK_A,false);


setMenuBar(m1);
m1.add(fi);
m1.add(edit);
m1.add(format);

fi.add(ne);
fi.add(op);
fi.add(sav);
fi.add(ex);

edit.add(cu);
edit.add(cp);
edit.add(pt);
edit.add(sel);

format.add(font);
f.add(fon);
f.add(siz);
f.add(fon_t);
f.add(fon_s);
f.add(ok);
f.add(cancel);

fon.add("Plain");
fon.add("Bold");
fon.add("Italic");
fon.add("Bold Italic");
fon.select(0);

siz.add("16");
siz.add("18");
siz.add("20");
siz.add("22");
siz.add("24");
siz.add("28");
siz.add("30");
siz.add("32");
siz.select(0);

add(t1);

ne.addActionListener(this);
op.addActionListener(this);
sav.addActionListener(this);
ex.addActionListener(this);

cu.addActionListener(this);
cp.addActionListener(this);
pt.addActionListener(this);
sel.addActionListener(this);

font.addActionListener(this);

fon.addActionListener(this);
siz.addActionListener(this);
ok.addActionListener(this);
cancel.addActionListener(this);

cu.setShortcut(mcu);
cp.setShortcut(mcp);
pt.setShortcut(mpt);
sel.setShortcut(mse);


addWindowListener(new wcls());
f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent i)
{
f.dispose();
}
});
}

public void actionPerformed(ActionEvent ae)
{
String s,s1,sh="",open="",cut="",copy="",paste="";
char ca[]=new char[600];
int r,len;

        if(ae.getSource()==ne)
        {
        t1.setText("");
        }

        if(ae.getSource()==ex)
        {
        System.exit(0);
        }

        if(ae.getSource()==op)
        {
                FileDialog fd=new FileDialog(this,"open");
                fd.setVisible(true);
                s=fd.getDirectory()+fd.getFile();
                        try
                        {
                                FileInputStream fis=new FileInputStream(s);
                                FileReader f=new FileReader(s);
                                BufferedReader br=new BufferedReader(f);
                                while((s1=br.readLine())!=null)
                                {
                                open=open+s1+"\n";
                                }
                                t1.setText(open);
                                t1.setCaretPosition(1);
                                f.close();
                        }
                catch(Exception e)
                        {
                        }
                }

                if(ae.getSource()==sav)
                {
                FileDialog fd1=new FileDialog(this,"save",FileDialog.SAVE);
                fd1.setVisible(true);
                s=fd1.getDirectory()+fd1.getFile();
                        try
                        {
                        FileWriter fr=new FileWriter(s);
                        s1=t1.getText();
                        char ca1[]=new char[s1.length()];
                        s1.getChars(0,s1.length(),ca1,0);
                        for(int v=0;v<s1.length();v++)
                        {
                        fr.write(ca1[v]);                               
                        }
                        fr.close();
                        }
                        catch(Exception e)
                        {}
                }

                if(ae.getSource()==cu)
                {
                        try
                        {
                        FileWriter fw=new FileWriter("d:/tem.txt");
                        cut=t1.getSelectedText();
                        fw.write(cut);
                        StringBuffer sf=new StringBuffer(t1.getText());
                        sf.delete(t1.getSelectionStart(),t1.getSelectionEnd());                       
                        t1.setText(sf+"");
                        fw.close();
                        }
                        catch(Exception e)
                        {}
                }

                if(ae.getSource()==cp)
                {
                        try
                        {
                        FileWriter fw1=new FileWriter("d:/tem.txt");
                        copy=t1.getSelectedText();
                        fw1.write(copy);
                        fw1.close();
                        }
                        catch(Exception e)
                        {}
                }

                if(ae.getSource()==pt)
                {
                        try
                        {
                        int carp=t1.getCaretPosition();

                        FileInputStream fis1=new FileInputStream("d:/tem.txt");
                        FileReader fr=new FileReader("d:/tem.txt");
                        BufferedReader br=new BufferedReader(fr);
                        t1.select(carp,(t1.getText()).length());
                        String sel_aft=t1.getSelectedText();
                        StringBuffer sf1=new StringBuffer(t1.getText());
                        sf1.delete(t1.getSelectionStart(),t1.getSelectionEnd());
                        t1.setText(sf1+"");
                        String ts;
                            while((ts=br.readLine())!=null)
                            {
                            paste=paste+ts+"\n";
                            }
                            t1.append(paste+sel_aft);
                            //t1.setCaretPosition(1);
                      
                                fis1.close();
                        }
                        catch(Exception e)
                        {}
                }
                if(ae.getSource()==sel)
                {
                t1.setCaretPosition(0);
                t1.select(0,(t1.getText()).length());
                }
                if(ae.getSource()==font)
                {
                f.setVisible(true);
                f.setSize(300,300);
                f.setLocation(100,100);
                f.setLayout(null);      
                fon_t.setBounds(45,35,120,100);
                fon_s.setBounds(170,35,50,30);
                fon.setBounds(45,50,120,100);
                siz.setBounds(170,50,50,70);
                ok.setBounds(230,35,60,20);
                cancel.setBounds(230,60,60,20);
                }
                int sel_ind=fon.getSelectedIndex();
                fon_t.setText(fon.getItem(sel_ind));
                fon_s.setText(siz.getItem(siz.getSelectedIndex()));
                int sie=Integer.parseInt(siz.getItem(siz.getSelectedIndex()));

                if(ae.getSource()==ok)
                {
                    if(fon.getItem(sel_ind)=="Plain")
                    {
                    fpl=new Font("TimesRoman",Font.PLAIN,sie);
                    t1.setFont(fpl);
                    }
                    if(fon.getItem(sel_ind)=="Bold")
                    {
                    fbo=new Font("TimesRoman",Font.BOLD,sie);
                    t1.setFont(fbo);
                    }
                    if(fon.getItem(sel_ind)=="Italic")
                    {
                    fit=new Font("TimesRoman",Font.ITALIC,sie);
                    t1.setFont(fit);
                    }
                    if(fon.getItem(sel_ind)=="Bold Italic")
                    {
                    fpl=new Font("TimesRoman",Font.ITALIC+Font.BOLD,sie);
                    t1.setFont(fpl);                    
                    }
                    f.setVisible(false);


                }
                if(ae.getSource()==cancel)
                {
                f.setVisible(false);
                }
                }

class wcls extends WindowAdapter
{
        public void windowClosing(WindowEvent we)
        {
        System.exit(0);
        }
}

public static void main(String ar[])
        {
                Notepad obj=new Notepad();
                obj.setVisible(true);
                obj.setSize(500,500);
        }
        }                        

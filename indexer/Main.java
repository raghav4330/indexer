import java.util.*;
import java.io.File;


class Main
{
Hash<String> h=new Hash<String>(1000);

void breakwords(String data,String file,String tag)
{
		String tokens[]=data.split("\\s");
		for(int i=0;i<tokens.length;i++)
		{
		h.insert(tokens[i],file,tag);
		//System.out.println(tokens[i]);
		}
}
		
void fetch(String str)
{
	int i,j,k,end,last,t;
	String s,ss,data;
	
	
	i=str.indexOf('<');
	while(i!=-1)
	{
			t=j=str.indexOf('>',i+1);
			k=str.indexOf(' ',i+1);
			if(j==-1)
			{
				i=str.indexOf('<',i+1);
				continue;
			}	   
			if(k!=-1 && k<j)
				j=k;
			s=str.substring(i+1,j);
			s=s.trim();
			//System.out.println(s);
			if(s.equals("title")||s.equals("h1"))
			{
				String rev="/"+s;
				end=str.indexOf(rev,j);
				System.out.println(j+" "+end);
				data=str.substring(t+1,end-1);
				System.out.println(data);
				j=end+rev.length();
				
				breakwords(data,"f1",s);
			}
				
			//System.out.println(s);
			i=str.indexOf('<',j+1);
	}
	
}
		
	
public static void main(String args[])
{
	Main m=new Main();
   String data="";
     try
     {
       Scanner ss=new Scanner(new File("html.txt"));
	
	     while(ss.hasNextLine())
	     {
	     String s=ss.nextLine();
	     data=data+s;
	     }
		 m.fetch(data);
	 }
	  catch(Exception e)
	 {
	 System.out.println(e);
	 }
}
	
}

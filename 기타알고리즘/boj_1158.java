 
import java.util.*;
import java.io.*;
public class Main {
 
	public static void main(String[] args) throws Exception{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 Queue <Integer> q=new LinkedList<>();
		 String [] temp=br.readLine().split(" ");
		 int n=Integer.parseInt(temp[0]);
		 int m=Integer.parseInt(temp[1]);
		 for(int i=1;i<=n;i++)
			 q.add(i);
		 StringBuilder sb=new StringBuilder();
		 sb.append("<");
		 while(!q.isEmpty()) {
			 int number=0;
			 for(int i=0;i<m-1;i++) {
				 number=q.poll();
				 q.add(number);
			 }
			 number=q.poll();
			 sb.append(number+", ");
			 
		 }
		 sb.delete(sb.length()-2,sb.length());
		 sb.append(">");
		 System.out.println(sb);
	}
	 

}

import java.util.*;
import java.io.*;
public class Main {

	public static int n,m;
	public static int [] output;
 
	public static void main(String[] args) throws Exception{
		 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		output=new int[m];
		 
		combi(0,m,0);
		
	}
	public static void combi(int cnt,int depth,int start) {
		if(cnt==depth) {
			print();
			return;
		}
		for(int i=start;i<n;i++) {
			 
			output[cnt]=i+1;
			combi(cnt+1,depth,i+1);
			 
		}
	}
	public static void print() {
		for(int i=0;i<m;i++) {
			System.out.print(output[i]+" ");
		}
		System.out.println();
	}
	 
}

import java.util.*;
import java.io.*;
public class Main {

	public static int [] output;
	public static int [] numbers;
	public static boolean [] visited;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		numbers=new int[n];
		output=new int[m];
		visited=new boolean [n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		perm(0);
		 
	}
	public static void perm(int cnt ) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			 if(visited[i]) continue;
			 visited[i]=true;
			 output[cnt]=numbers[i];
			 perm(cnt+1);
			 visited[i]=false;
		}
	}
	 
	 
}
 

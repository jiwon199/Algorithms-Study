package backjoon;
import java.util.*;
import java.io.*;

public class Main {
	public static long [] dp;
	public static long [] divDp;
	public static int n; 
	public static int m; 
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());//13
			m=Integer.parseInt(st.nextToken());//19
			dp=new long[40];
			divDp=new long[40];
			divDp[0]=1;
			dp[0]=m;
			 
			if(m==n) {
				sb.append("1 \n");
				continue;
			}
			if (m/2 < n) n = m - n;
			recur(1);
			 
				 
		}
		System.out.println(sb);
	}
 
	public static void recur(int depth) {
		if(depth==(n+1)) { 
			sb.append(dp[n-1]/divDp[n-1]+"\n");
			return;
		}
		divDp[depth]=divDp[depth-1]*(depth+1);
		dp[depth]=(dp[depth-1]*(m-depth)) ;	 
		recur(depth+1 );
		
	}
 

}

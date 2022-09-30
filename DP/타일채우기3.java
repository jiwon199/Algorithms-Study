import java.util.*;
import java.io.*;

public class Main {

	 
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long [] dp=new long [n+1];
		long [] sum=new long[n+1];
		 
		if(n==1) System.out.println(2);
		else if(n==2) System.out.println(7);
		else {
			dp[0]=1;
			dp[1]=2;
			dp[2]=7;
			sum[0]=1;
			sum[1]=3;
			sum[2]=10;
			for(int i=3;i<=n;i++) {
				dp[i]=(2*dp[i-1]+3*dp[i-2]+2*sum[i-3])%1000000007;
				sum[i]=sum[i-1]+dp[i];
			}
			System.out.println(dp[n]);
			
		}

	}
	 

}

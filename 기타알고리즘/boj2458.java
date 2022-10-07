import java.util.*;
import java.io.*;

public class Main {
	public static int [][] distance;
	public static int n,m,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		distance=new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			//크면 +1 작으면 -1
			distance[a][b]=1;
			distance[b][a]=-1;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					//i는 k보다 작고 k는 j보다 작으면
					if(distance[i][k]==-1&&distance[k][j]==-1) {
						distance[i][j]=-1;
					}
					//i는 k보다 크고 k는 j보다 크면
					if(distance[i][k]==1&&distance[k][j]==1) {
						distance[i][j]=1;
					}
				}
			}
		}
		
		//자기가 몇번째인지 알 수 있는 사람 세기
		for(int i=1;i<=n;i++) {
			ans+=count(i);
		}
		System.out.println(ans);
		
	}
	public static int count(int i) {
		int count=0;
		 
		for(int j=1;j<=n;j++) {
			if(distance[i][j]==0) count++;
		}
		 
		if(count==1) return 1;
		else return 0;
	}
	 
	 

}

package backjoon;

import java.util.*;
import java.io.*;

public class Main {
 
	static boolean [] visited;
	static int [][] graph;
	static int n,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		ans=Integer.MAX_VALUE;
		graph=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visited=new boolean[n];
		 
		for(int i=0;i<n;i++) {
			Arrays.fill(visited, false);
			visited[i]=true;
			dfs(i,i,0,0);
		}
		 
		System.out.println(ans);
	}
	
	public static void dfs(int start,int now,int depth,int sum) {
		 if(depth==n-1) {
			 if(graph[now][start]!=0) //마지막 도시에서 다시 시작도시로 돌아와 원점으로
				 ans=Math.min(ans, sum+graph[now][start]);
			 return; 
		 }
		 
		 for(int i=0;i<n;i++) {
			 if(!visited[i]&&graph[now][i]!=0) {
				 visited[i]=true;
				 dfs(start,i,depth+1,sum+graph[now][i]);
				 visited[i]=false;
			 }
		 }
		
	}
 
}

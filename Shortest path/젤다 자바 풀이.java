package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	static int [][] graph;
    static boolean [][] visited;
    static int [][] distance;
	 
	static int n;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = {0,0, -1, 1 };
	static PriorityQueue <int []> q;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int tc=0;
		 
		while (true) {
			n=Integer.parseInt(br.readLine());
			if(n==0) break;
			graph=new int[n][n];
			visited=new boolean[n][n];
			distance=new int[n][n];
			//도둑루피, x,y
			q=new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
					distance[i][j]=Integer.MAX_VALUE;
				}
			}
			int ans=dijkstra();
			tc++;
			System.out.println("Problem "+tc+": "+ans);
		}
		
	}
	public static int dijkstra() {
		  
		  
		 q.add(new int [] {graph[0][0],0,0});
		 
		 while(!q.isEmpty()) {
			 int [] pos=q.poll();
			  
			 int cost=pos[0];
			 if(distance[pos[1]][pos[2]]<cost) continue;
			 distance[pos[1]][pos[2]]=cost;
			 
			 //System.out.println(pos[1]+" "+pos[2]+" "+cost);
			 
			 //q.clear();
			 checkNear(pos[1],pos[2]);
		 }
		 return distance[n-1][n-1];
		 
	}
	public static void checkNear(int x,int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				int cost=distance[x][y]+graph[nx][ny];
				if (cost<distance[nx][ny])
					q.add(new int [] {cost,nx,ny});	 
			}
		}
		 
	}
	public static boolean isNear(int a, int b, int c,int d) {
		if(a==b+1&&c==d) return true;
		if(a==b-1&&c==d) return true;
		if(a==b&&c+1==d) return true;
		if(a==b+1&&c-1==d) return true;
		 
		return false;
		
	}

}

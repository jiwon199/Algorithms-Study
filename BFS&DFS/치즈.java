import java.util.*;
import java.io.*;

public class Main {

	 
	static int [][] graph;
	static int [][] originGraph;
	static int n,m,time,count;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		originGraph=new int[n][m];
		time=0;
		count=0;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				originGraph[i][j]=graph[i][j];
			}
		}
		
		while(true) {
			int now=getNum();
			if(now==0) break;
			count=now;
			
			makeAir();
			melt();
			 
			time++;
		}
		System.out.println(time);
		System.out.println(count);

	}
	//바깥 공기를 -1로 만든다.
	public static void makeAir() {
		Queue <int []> q=new LinkedList<>();
		q.add(new int [] {0,0});
		graph[0][0]=-1;
		
		while(!q.isEmpty()) {
			int [] pos=q.poll();
			for(int i=0;i<4;i++) {
				int nx=pos[0]+dx[i];
				int ny=pos[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(graph[nx][ny]==0) {
						graph[nx][ny]=-1;
						q.add(new int [] {nx,ny});
					}
				}
			}
		}
		copy();
		
	}
	 
	//-1과 인접한 치즈를 녹인다.
	public static void melt() {
		Queue <int []> q=new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(isNearAir(i,j)) {
					graph[i][j]=-1;
					q.add(new int [] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int [] pos=q.poll();
			for(int i=0;i<4;i++) {
				int nx=pos[0]+dx[i];
				int ny=pos[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					if(graph[nx][ny]==0) {
						graph[nx][ny]=-1;
						q.add(new int [] {nx,ny});
					}
				}
			}
		}
		 
		copy();
	}
	public static boolean isNearAir(int x,int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				if(originGraph[nx][ny]==-1) return true;
			}
		}
		return false;
	}
	public static void copy() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				originGraph[i][j]=graph[i][j];
			}
		}
	}
	public static int getNum() {
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
	 
}

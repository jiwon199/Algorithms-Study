package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	static int [][] graph;
    static int [][] originGraph;
	static int R,C,T,up,down;
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,-1,1};
	static Queue <int [] >q=new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		 
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		graph=new int[R][C];
		originGraph=new int[R][C];
		up=-1;
		down=-1;
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				originGraph[i][j]=graph[i][j];
				if(graph[i][j]==-1&&up==-1) up=i;
				else if(graph[i][j]==-1&&up!=-1) down=i;
				
			}
		}
		
		int time=0;
		while(true) {
			if(time==T) break;
			time++;
			spread();
			 
			sync();
			upClear();
			downClear();
		 
		 
		}
		System.out.println(count());
	}
	
	public static void spread() {
		q.clear();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				q.add(new int [] {i,j,graph[i][j]/5});
			}
		}
		
		while(!q.isEmpty()) {
			int [] pos=q.poll();
			spreadOne(pos[0],pos[1],pos[2]);
		}
	}
	public static void spreadOne(int x,int y,int amount) {
		int cnt=0;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&ny>=0&&nx<R&&ny<C&&graph[nx][ny]!=-1) {
				graph[nx][ny]+=amount;
				cnt++;
			}
		}
		graph[x][y]-=amount*cnt;
		
	}
	public static int count() {
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(graph[i][j]!=-1)
					sum+=graph[i][j];
				//System.out.print(graph[i][j]+" ");
			}
			//System.out.println();
		}
		return sum;
	}
	public static void upClear() {
		//왼쪽이동 
		graph[up][1]=0;
		for(int i=2;i<C;i++)
			graph[up][i]=originGraph[up][i-1];
		 //위쪽 이동
		for(int i=up-1;i>=0;i--)
			graph[i][C-1]=originGraph[i+1][C-1];
		 //오른쪽이동
		for(int i=C-2;i>=0;i--)
			graph[0][i]=originGraph[0][i+1];
		 //아래쪽 이동
		for(int i=1;i<up;i++)
			graph[i][0]=originGraph[i-1][0];   
	}
	public static void downClear() {
		//왼쪽이동
		graph[down][1]=0;
		for(int i=2;i<C;i++)
			graph[down][i]=originGraph[down][i-1];
		 //아래쪽 이동
		for(int i=down+1;i<R;i++)
			graph[i][C-1]=originGraph[i-1][C-1];  
		//오른쪽 이동
		 for(int i=C-2;i>=0;i--)
			graph[R-1][i]=originGraph[R-1][i+1];
		 //위쪽 이동
		for(int i=R-2;i>down;i--)
			graph[i][0]=originGraph[i+1][0];  
	}
	public static void sync() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				originGraph[i][j]=graph[i][j];
				 
			}
		}
	 
	}

}

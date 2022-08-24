package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	static int[][] graph;
	static boolean [][] visited;
	static int n,size;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = {0,0, -1, 1 };
	static PriorityQueue <int []> fishList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph=new int[n][n];
		int x=0;
		int y=0;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				if(graph[i][j]==9) {
					x=i;
					y=j;
				}
			}
		}
		fishList=new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0]==o2[0]) {
					if(o1[1]==o2[1]) return o1[2]-o2[2];
					return o1[1]-o2[1];
				}
				 
				return o1[0]-o2[0];
			}
		 });
		int time=0;
		int eatNum=0;
		size=2;
		while(true) {
			searchFish(x,y); //물고기 탐색
			//먹을 수 있는 물고기 없으면 종료
			if(fishList.size()==0) break;
			 
			//먹고 이동
			graph[x][y]=0;
			int [] pos=fishList.poll();
			x=pos[1];
			y=pos[2];
			time+=pos[0];
			graph[x][y]=9;
			eatNum++;
			
			//크기 커지는 경우
			if(eatNum==size) {
				size++;
				eatNum=0;
			}
			
		}
		System.out.println(time);
		

	}
	public static void searchFish(int x,int y) {
		fishList.clear();
		visited=new boolean[n][n];
		//bfs로 탐색하면서 갈수 있으면서 작은 물고기들 탐색
		Queue <int []> q=new LinkedList<>();
		q.add(new int [] {x,y,0});
		visited[x][y]=true;
	 
		while(!q.isEmpty()) {
			int []info=q.poll();
			for(int i=0;i<4;i++) {
				int nx=info[0]+dx[i];
				int ny=info[1]+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					if(visited[nx][ny]==false&&graph[nx][ny]<=size) {
						if(graph[nx][ny]>0&&graph[nx][ny]<size) fishList.add(new int [] {info[2]+1,nx,ny});
						visited[nx][ny]=true;
						q.add(new int [] {nx,ny,info[2]+1});
					}
				}
			}
		}
		
	}

	 

}

package backjoon;

import java.util.*;
import java.io.*;

public class Main {
  
	static int [][] graph;
	static int [][] orignGraph;
	static int n,m,d,totalCnt,ans;
	static int [] output;
	static Set <int []> set=new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] info=br.readLine().split(" ");
		n=Integer.parseInt(info[0]);
		m=Integer.parseInt(info[1]);
		d=Integer.parseInt(info[2]);
		ans=0;
		graph=new int[n][m];
		orignGraph=new int[n][m];
		output=new int[3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
				orignGraph[i][j]=graph[i][j];
			}
		}
		 
		combi(0,0);
		System.out.println(ans);
	}
	public static void combi(int cnt, int start) {
		if(cnt==3) {
			totalCnt=0;
			clearGraph();
			 
			round();
			ans=Math.max(ans, totalCnt); 
			return;
		}
		for(int i=start;i<m;i++) {
			output[cnt]=i;
			combi(cnt+1,i+1);
		}
	}
	public static void round() {
		if(isGameOver()) {
			return;
		}
		attack();	 
		move();
		round();
		
	}
	 
	public static void attack() {
		set.clear();
		 for(int pos:output) {
			 select(pos);
		 }
		 
		 for(int [] pos:set) {
			 if(graph[pos[0]][pos[1]]==1) {
				 graph[pos[0]][pos[1]]=0;
				 totalCnt++;
				 
			 }
		 }
		 
	}
 
	//graph[n][pos]위치의 궁수가 공격할 적을 선택
	public static void select(int pos) {
		int x=-1;
		int y=-1;
		int minDistance=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) {
					int distance=Math.abs(n-i)+Math.abs(pos-j);
					//공격 범위안이면
					if(distance<=d) {
						//공격 범위 안에 있었던 적들 중 가장 가까운 적이면
						if(distance<minDistance) {
							x=i;
							y=j;
							minDistance=distance;
							 
						}
						//거리가 같으면 가장 왼쪽의 적 선택(=y가 작은 적)
						else if(distance==minDistance) {
							if(j<=y) {
								x=i;
								y=j;
							}
						}
					}
				}
			}
		}
	 
		if(x!=-1&&y!=-1) {
			set.add(new int [] {x,y});
		}
	}
	public static void move() {
		int [][] newGraph=new int[n][m];
		 
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				newGraph[i][j]=graph[i-1][j];
			}
		}
		 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j]=newGraph[i][j];
			}
		}
		 
	}
	public static boolean isGameOver() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) return false;
			}
		}
		return true;
	}
	public static void clearGraph() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				 graph[i][j]=orignGraph[i][j];
			}
		}
	}
	 
 
}

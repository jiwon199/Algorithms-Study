package backjoon;

import java.util.*;
import java.io.*;

public class Main {
	public static int[][] graph;
	public static int [][] memoGraph;
	public static int n;
	public static int m;

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		int r = Integer.parseInt(info[2]);
		graph = new int[n][m];
		memoGraph=new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				graph[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		setMemoGraph();
		
		//회전
		String [] rotateInfo=br.readLine().split(" ");
		for(int i=0;i<r;i++) {
			int oper=Integer.parseInt(rotateInfo[i]);
			if(oper==1) reverse_ver();
			else if(oper==2) reverse_hor();
			else if(oper==3) rotate_right();
			else if(oper==4) rotate_left();
			else if(oper==5) switch_right();
			else switch_left();
		}
		
		// 출력
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 1번 연산 상하 뒤집기
	public static void reverse_ver() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j]=memoGraph[n-i-1][j];
			}
		}
		setMemoGraph();
	}

	// 2번 연산 좌우 뒤집기
	public static void reverse_hor() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j]=memoGraph[i][m-j-1];
			}
		}
		setMemoGraph();
	}

	// 3번 연산 오른쪽 90 회전
	public static void rotate_right() {
		graph=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j]=memoGraph[n-j-1][i];
			}
		}
	
		reBuild();
		setMemoGraph();
	}

	// 4번 연산 왼쪽 90 회전
	public static void rotate_left() {
		graph=new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j]=memoGraph[j][m-i-1];
			}
		}
		reBuild();
		setMemoGraph();
		 
	}

	// 5번 연산 자리바꾸기1
	public static void switch_right() {
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 //1사분면
				 if(i>=0&&i<n/2&&j>=0&&j<m/2 ) graph[i][j]=memoGraph[n/2+i][j];
				 //2사분면
				 else if(i>=0&&i<n/2&&j>=m/2&&j<m) graph[i][j]=memoGraph[i][j-m/2];
				 //3사분면
				 else if(i>=n/2&&i<n &&j>=m/2&&j<m) graph[i][j]=memoGraph[i-n/2][j];
				 //4사분면
				 else graph[i][j]=memoGraph[i][m/2+j];
			 }
		 }
		 setMemoGraph();
	}

	//6번 연산 자리바꾸기2
	public static void switch_left() {
		for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 //1사분면
				 if(i>=0&&i<n/2&&j>=0&&j<m/2 ) graph[i][j]=memoGraph[i][m/2+j];
				 //2사분면
				 else if(i>=0&&i<n/2&&j>=m/2&&j<m) graph[i][j]=memoGraph[n/2+i][j];
				 //3사분면
				 else if(i>=n/2&&i<n &&j>=m/2&&j<m) graph[i][j]=memoGraph[i][j-m/2];
				 //4사분면
				 else graph[i][j]=memoGraph[i-n/2][j];
			 }
		 }
		 setMemoGraph();

	}
	public static void reBuild() {
		int temp=m;
		m=n;
		n=temp;
		memoGraph=new int[n][m];
	}
	public static void setMemoGraph() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				memoGraph[i][j]=graph[i][j];
			}
		}
	}
	

}

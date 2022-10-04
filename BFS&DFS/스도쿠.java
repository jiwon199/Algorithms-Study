 
import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;
 
public class Main {
	 
	static int [][] graph;
	static int blankNum=0; //빈칸의 수
	static List <int []> pos; //빈칸들의 좌표 
	static int [][] scope= {
			{0,3,0,3},{0,3,3,6},{0,3,6,9},
			{3,6,0,3},{3,6,3,6},{3,6,6,9},
			{6,9,0,3},{6,9,3,6},{6,9,6,9}
	};
	public static void main(String[] args) throws Exception{
	 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		graph=new int[9][9];
		pos=new ArrayList<>();
		for(int i=0;i<9;i++) {
			String line=br.readLine();
			for(int j=0;j<9;j++) {
				graph[i][j]=line.charAt(j)-'0';
				if(graph[i][j]==0) {
					blankNum++;
					pos.add(new int [] {i,j});
				}
			}
		}
		 
		//탐색 시작
		dfs(0);
		 
		
	}
	public static void print() {
		//출력
		for(int i=0;i<9;i++) {
			 for(int j=0;j<9;j++) {
				 System.out.print(graph[i][j]);
				 }
				System.out.println();
				}
	}
	 //0~8 리턴
	public static int findArea(int x,int y) {
		if(x>=0&&x<3&&y>=0&&y<3) return 0;
		else if(x>=0&&x<3&&y>=3&&y<6) return 1;
		else if(x>=0&&x<3&&y>=6&&y<9) return 2;
		else if(x>=3&&x<6&&y>=0&&y<3) return 3;
		else if(x>=3&&x<6&&y>=3&&y<6) return 4;
		else if(x>=3&&x<6&&y>=6&&y<9) return 5;
		else if(x>=6&&x<9&&y>=0&&y<3) return 6;
		else if(x>=6&&x<9&&y>=3&&y<6) return 7;
		else return 8;
		 
	}
	public static boolean checkArea(int x,int y,int num) {
		int area=findArea(x,y);
		for(int i=scope[area][0];i<scope[area][1];i++) {
			for(int j=scope[area][2];j<scope[area][3];j++) {
				if(graph[i][j]==num) return false;
			}
		}
		return true;
	}
	
	 
	public static boolean checkRow(int x,int y,int num) {
		for(int i=0;i<9;i++) {
			if(graph[x][i]==num) return false;
		}
		return true;
	}
	public static boolean checkCol(int x,int y,int num) {
		for(int i=0;i<9;i++) {
			if(graph[i][y]==num) return false;
		}
		return true;
	}
	public static void dfs(int cnt) {
		//빈칸 다 채웠으면 리턴
		 if(cnt==blankNum) {
			 print();
			 System.exit(0);
		 }
		 int x=pos.get(cnt)[0];
		 int y=pos.get(cnt)[1];
		 for(int i=1;i<=9;i++) {
			 if(checkArea(x,y,i)&&checkRow(x,y,i)&&checkCol(x,y,i)) {
				 graph[x][y]=i;
				 dfs(cnt+1);
				 graph[x][y]=0;
				 
			 }  
		 }
		 return; 
	}
}

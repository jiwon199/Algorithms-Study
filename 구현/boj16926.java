package backjoon;

import java.util.*;
import java.io.*;

 
public class Main { 
	public static int [][] graph;
	public static void main(String [] args) throws Exception{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 String [] info=br.readLine().split(" ");
		 int n=Integer.parseInt(info[0]);
		 int m=Integer.parseInt(info[1]);
		 int r=Integer.parseInt(info[2]);
		 
		 graph=new int [n][m];
		 for(int i=0;i<n;i++) {
			 String [] temp=br.readLine().split(" ");
			 for(int j=0;j<m;j++) {
				 graph[i][j]=Integer.parseInt(temp[j]);
			 }
		 }
		 
		 rotate(0,0,n-1,m-1,r);
		 
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 System.out.print(graph[i][j]+" ");
			 }
			 System.out.println();
		 }
		 

		
	}
	public static void rotate (int x1, int y1, int x2, int y2,int r) {
		if(x1>=x2 || y2<=y1) return;
		else {
			 
			List <Integer> list=new ArrayList<>();
			for(int i=x1;i<=x2;i++) list.add(graph[i][y1]);
			for(int i=y1+1;i<=y2;i++) list.add(graph[x2][i]);
			for(int i=x2-1;i>=x1;i--) list.add(graph[i][y2]);
			for(int i=y2-1;i>=y1+1;i--) list.add(graph[x1][i]);
		 
			int l=list.size();
			for(int i=0;i<r;i++) {
				int num=list.get(l-1);
				list.remove(l-1);
				list.add(0,num);
			}
			 
			int index=0;
			for(int i=x1;i<=x2;i++)  graph[i][y1]=list.get(index++);
			for(int i=y1+1;i<=y2;i++)  graph[x2][i]=list.get(index++);
			for(int i=x2-1;i>=x1;i--)  graph[i][y2]=list.get(index++);
			for(int i=y2-1;i>=y1+1;i--)  graph[x1][i]=list.get(index++);
			//안쪽의 줄 회전
			rotate(x1+1,y1+1,x2-1,y2-1,r);
		}
	}
 
}

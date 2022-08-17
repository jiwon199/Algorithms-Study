package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	public static int [][] graph;
	public static String ans="";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		graph=new int[n][n];
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<n;j++) graph[i][j]=line.charAt(j)-'0';
		}
		 
		check(0,0,n);
		System.out.println(ans);
	}
	public static void check(int x,int y,int size) {
		 
		if(isZipAble(x,y,size)) {
			ans+=String.valueOf(graph[x][y]) ;
			//System.out.println(x+" "+y+" "+size+" 압축완!");
			return;
			}
		else {
			ans+="(";
			int next=size/2;
			check(x,y,next);
			check(x,y+next,next);
			check(x+next,y,next);		 
			check(x+next,y+next,next);
			ans+=")";
		}
	}
	public static boolean isZipAble(int x,int y,int size) {
		int color=graph[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(graph[i][j]!=color) return false;
			}
		}
		return true;
	}
	 

}

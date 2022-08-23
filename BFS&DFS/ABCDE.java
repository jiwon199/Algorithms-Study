package backjoon;

import java.util.*;
import java.io.*;
class Node{
	List <Integer> list ;
	 
	public  Node( ) {
		list=new ArrayList<>(); 
	}
	public void add(int num) {
		list.add(num);
	}
	 
}
public  class Main {
	 
	public static Node [] parents; 
	public static int totalCnt=0;
	static boolean [] visited;
	public static int ans=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] info=br.readLine().split(" ");
		int n=Integer.parseInt(info[0]);
		int m=Integer.parseInt(info[1]);
 
		parents=new Node[n];
		visited=new boolean[n];
		for(int i=0;i<n;i++) {
			Node d=new Node();
			parents[i]=d;
		}
		 
		for(int i=0;i<m;i++) {
			String [] friends=br.readLine().split(" ");
			parents[Integer.parseInt(friends[0])].add(Integer.parseInt(friends[1]));
			parents[Integer.parseInt(friends[1])].add(Integer.parseInt(friends[0]));
		}
		 

		 for(int i=0;i<n;i++) {
			 totalCnt=0;
			 visited=new boolean[n];
			 check(i,0);
			 
		} 
		 
		System.out.println(ans);
	}
	 
	public static void check(int a,int cnt) {
		//System.out.println(a+" 방문");
		visited[a]=true;
		if(cnt>=4) { ans=1; return;}
		for(int friend:parents[a].list) {
			 if(friend!=a&&visited[friend]==false) {
				 check(friend,cnt+1);
			 }
		 }
		visited[a]=false;
	}
	 
}

import java.util.*;
import java.io.*;

public class Main {
	public static int [] output ;
	public static int [] directionCnt;
	public static int [][] originGraph;
	public static int [][] graph;
	public static int CCTVNum;
	public static int n;
	public static int m;
	public static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp=br.readLine().split(" ");
		n=Integer.parseInt(tmp[0]);
		m=Integer.parseInt(tmp[1]);
		graph=new int[n][m];
		originGraph=new int[n][m];
		int cnt=0;
		
		for(int i=0;i<n;i++) {
			String [] line=br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				graph[i][j]=Integer.parseInt(line[j]);
				originGraph[i][j]=graph[i][j];
				if(graph[i][j]!=0&&graph[i][j]!=6) cnt++;
			}
		}
		
		output=new int[cnt];
		directionCnt=new int[cnt];
		CCTVNum=cnt;
		int idx=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(graph[i][j]==1) directionCnt[idx++]=4;
				else if(graph[i][j]==2) directionCnt[idx++]=2;
				else if(graph[i][j]==3) directionCnt[idx++]=4;
				else if(graph[i][j]==4) directionCnt[idx++]=4;
				else if(graph[i][j]==5) directionCnt[idx++]=1;
			}
		}
		recur(0);
		System.out.println(ans);
		
		
		 
	}
	public static void recur(int cnt) {
		if(cnt==CCTVNum) { 
			//cctv들의 방향이 output일때 감시가능 칸 구하기			 
			setGraph();
			ans=Math.min(countZero(), ans);
			clearGraph();
			return;
		}
		for(int i=0;i<directionCnt[cnt] ;i++) {
			output[cnt]=i;
			recur(cnt+1);
		}
	}
	public static void setGraph() {
		int idx=0;
		//감시가 되는 부분을 -1로 바꾼다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				  if(graph[i][j]==1) see(1,output[idx++],i,j);
				  else if(graph[i][j]==2) see(2,output[idx++],i,j);
				  else if(graph[i][j]==3) see(3,output[idx++],i,j);
				  else if(graph[i][j]==4) see(4,output[idx++],i,j);
				  else if(graph[i][j]==5) see(5,output[idx++],i,j);
			}
		}
		
	}
	public static void see(int cctv,int direction,int x,int y) {
		 if(cctv==1) {
			 if(direction==0) seeUp(x,y);
			 else if(direction==2) seeDown(x,y);
			 else if(direction==3) seeLeft(x,y);
			 else seeRight(x,y);
		 }
		 else if(cctv==2) {
			 if(direction==0) {
				 seeUp(x,y);
				 seeDown(x,y);
			 }
			 else {
				 seeLeft(x,y);
				 seeRight(x,y);
			 }
		 }
		 else if(cctv==3) {
			 if(direction==0) {
				 seeUp(x,y);	 
				 seeRight(x,y);
			 }
			 else if(direction==1) {
				 seeUp(x,y);
				 seeLeft(x,y);			  
			 }
			 else if(direction==2) { 
				 seeDown(x,y);
				 seeLeft(x,y);	 
			 }
			 else if(direction==3) {
				 seeDown(x,y);			 
				 seeRight(x,y);
			 }
		 }
		 else if(cctv==4) {
			 if(direction==0) {
				 seeDown(x,y);
				 seeLeft(x,y);		
				 seeRight(x,y);
			 }
			 else if(direction==1) {
				 seeUp(x,y);  
				 seeLeft(x,y);		
				 seeRight(x,y);
			 }
			 else if(direction==2) { 
				 seeUp(x,y);
				 seeDown(x,y);
				 seeRight(x,y);
			 }
			 else if(direction==3) {
				 seeUp(x,y);
				 seeDown(x,y);
				 seeLeft(x,y);				 
			 }
		 }
		 else {
			 seeUp(x,y);
			 seeDown(x,y);
			 seeLeft(x,y);		
			 seeRight(x,y);
		 }
	}
	public static void seeUp(int x,int y) {
		while(true) {
			x-=1;
			if(isBreak(x,y)) break;
			if(graph[x][y]==0) graph[x][y]=-1;
		}
	}
	public static void seeDown(int x,int y) {
		while(true) {
			x+=1;
			if(isBreak(x,y)) break;
			if(graph[x][y]==0) graph[x][y]=-1;
		}
	}
	public static void seeLeft(int x,int y) {
		while(true) {
			y-=1;
			if(isBreak(x,y)) break;
			if(graph[x][y]==0) graph[x][y]=-1;
		}
	}
	public static void seeRight(int x, int y) {
		while(true) {
			y+=1;
			if(isBreak(x,y)) break;
			if(graph[x][y]==0) graph[x][y]=-1;
		}
	}
	public static boolean isBreak(int x, int y) {
		if(x<0||y<0||x>=n||y>=m) return true;
		if(graph[x][y]==6) return true;
		return false;
	}
	public static int countZero() {
		int res=0;
		//0의 개수를 세서 반환
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				 if(graph[i][j]==0) res++;
			}
		}
		return res;
	}
	public static void clearGraph() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				 graph[i][j]=originGraph[i][j];
			}
		}
	}
	 
}

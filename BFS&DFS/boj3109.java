import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int ans=0;
	static int [][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp=br.readLine().split(" ");
		n=Integer.parseInt(tmp[0]);
		m=Integer.parseInt(tmp[1]);
		graph=new int[n][m];
		//빈공간0 건물 2 파이프1이라고 하자.
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				if(line.charAt(j)=='.') graph[i][j]=0;
				else graph[i][j]=2;
			}
		}
		for(int i=0;i<n;i++) {
			dfs(i,0);
		}
		System.out.println(ans);
	 
	}
	//파이프를 설치  
	public static boolean dfs(int x,int y ) {
		if(y==m-1) {
			graph[x][y]=1;
			ans++;
			return true;
		}
		graph[x][y]=1;
		//대각선 위로 갈 수 있으면 거기로. 
		//단순히 바로 대각선 칸이 비었다고 갈수 있는게 아니라 쭉 갔을때 성공하는지 실패하는지를 따짐
		if(isCanGo(x-1,y+1)&&dfs(x-1,y+1)) {
			 return true;
		}
		//아니면 직진
		else if(isCanGo(x,y+1)&&dfs(x,y+1 )) {
			 return true;
		}
		//아니면 대각선 아래
		else if(isCanGo(x+1,y+1)&&dfs(x+1,y+1 ) ) {
			 return true;
		}
		//그것도 아니면 파이프 설치 못하니 리턴
		return false;
		 
	}
	public static boolean isCanGo(int x,int y) {
		if(x>=0&&y>=0&&x<n&&y<m) {
			if(graph[x][y]==0) return true;
		}
		return false;
	}
 
}

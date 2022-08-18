import java.util.*;
import java.io.*;

public class Main {

	static Map<Character,Integer> map=new HashMap<>();//0이면 방문안함, 1이면 방문함.
	static char [][] graph;
	static int n,m,ans;
	static int [] dx= {-1,1,0,0}; 
	static int [] dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] tmp=br.readLine().split(" ");
		n=Integer.parseInt(tmp[0]);
		m=Integer.parseInt(tmp[1]);
		ans=0;
		graph=new char[n][m];
		for(int i=0;i<n;i++) {
			int j=0;
			for(char c:br.readLine().toCharArray()) {
				graph[i][j++]=c;
				map.put(c, 0);
			}
		}
		dfs(0,0,0);
		System.out.println(ans);
	 
	}
	public static void dfs(int x,int y,int cnt ) {
		//System.out.println(x+" "+y+" "+cnt);
		if(!isCanGo(x,y)) {
			ans=Math.max(cnt, ans);
			return;
		}
		if(map.get(graph[x][y])==1) {
			ans=Math.max(cnt, ans);
			return;
		}
		map.put(graph[x][y],1);
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			dfs(nx,ny,cnt+1);
		}
		map.put(graph[x][y],0);
		 
	}
	public static boolean isCanGo(int x,int y) {
		if(x<0||y<0||x>=n||y>=m) {
			return false;
		}
		return true;
	}
	 
 
}

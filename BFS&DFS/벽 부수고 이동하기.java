import java.util.*;
import java.io.*;

public class Main {

	 
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int [][] graph=new int[n][m];
		int [][][] visited=new int[n][m][2];
		for(int i=0;i<n;i++) {
			String info=br.readLine();
			for(int j=0;j<m;j++) {
				graph[i][j]=info.charAt(j)-'0';
				for(int k=0;k<2;k++) visited[i][j][k]=Integer.MAX_VALUE;
			}
		}
		
		int [] dx= {-1,1,0,0};
		int [] dy= {0,0,-1,1};
		Queue <int []> q=new LinkedList<>();
		q.add(new int [] {0,0,1}); //x,y,남은 필살기 수
		visited[0][0][1]=1;
		while(!q.isEmpty()) {
			int [] info=q.poll();
			
			for(int i=0;i<4;i++) {
				int nx=info[0]+dx[i];
				int ny=info[1]+dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					int move=visited[info[0]][info[1]][info[2]]+1;
					if(graph[nx][ny]!=1) {
						if(visited[nx][ny][info[2]]>move) {
							visited[nx][ny][info[2]]=move;
							q.add(new int [] {nx,ny,info[2]});
						}
					}
					else {
						if(info[2]==1) {
							if(visited[nx][ny][0]>move) {
								visited[nx][ny][0]=move;
								q.add(new int [] {nx,ny,0});
							}
						}
					}
				}
			}
		}
		int ans=Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);

	}
	 

}

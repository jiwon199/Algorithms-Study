import java.util.*;
import java.io.*;

public class Main {

	public static int[][] graph;
	public static int[][][] visited;
	public static int k, w, h;
	public static Queue<int[]> q;

	public static Map<String,Integer> map=new HashMap<>();
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		graph = new int[h][w];
		visited = new int[h][w][k+1];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
				for(int p=0;p<=k;p++)
					visited[i][j][p] = Integer.MAX_VALUE;
			}
		}
		
		q = new LinkedList<>();
		q.add(new int[] { 0, 0, k });
		visited[0][0][k] = 0;
	  
		int[] dx = { -1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dy = { 0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1 };

		int cnt=0;
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			int k = pos[2];
			int move = visited[x][y][k] + 1;
			 
			cnt++; 
			for (int i = 0; i < 12; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				 
				if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
					if (graph[nx][ny] != 1) {
						   
							if (i < 4 && visited[nx][ny][k]>move) {	 
								q.add(new int[] { nx, ny, k });
								visited[nx][ny][k] =move;		 
							}
							if (i >= 4 && k >= 1&&visited[nx][ny][k-1]>move) {
								 
								q.add(new int[] { nx, ny, k-1  });
								visited[nx][ny][k-1] = move;		 
							}
						 
					}
				}
			}
		}
		
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<=k;i++) {
			if(ans>visited[h - 1][w - 1][i]) ans=visited[h - 1][w - 1][i];
		}
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);

	}

}

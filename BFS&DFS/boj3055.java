package backjoon;

import java.util.*;
import java.io.*;

public class Main {

	static char[][] graph;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = {0,0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new char[n][m];
		visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		int startX = 0;
		int startY = 0;
		int targetX = 0;
		int targetY = 0;

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = line.charAt(j);
				if (graph[i][j] == 'D') {
					targetX = i;
					targetY = j;
				}
				if (graph[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		q.add(new int[] { startX, startY, 0 });
		visited[startX][startY] = true;
		int ans = -1;
		int waterState=0;
		while (!q.isEmpty()) {
			int[] dochi = q.poll();

			 

			if (dochi[0] == targetX && dochi[1] == targetY) {
				ans = dochi[2];
				break;
			}
			while(dochi[2]>=waterState) {
				// 물이 퍼지고
				spreadWater();
				waterState++;
			}
			 
			 
			// 도치의 다음 위치를 넣고
			for (int i = 0; i < 4; i++) {
				int nx = dochi[0] + dx[i];
				int ny = dochi[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (graph[nx][ny] != 'X' && graph[nx][ny] != '*' && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny, dochi[2] + 1 });
						 
					}
				}
			}

		}
		if (ans == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);

	}

	public static void spreadWater() {
		List<int[]> waterPos = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == '*')
					waterPos.add(new int[] { i, j });
			}
		}

		for (int[] pos : waterPos) {
			spread(pos[0], pos[1]);
		}
	}

	public static void spread(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] != 'X'&&graph[nx][ny] != 'D') {
				graph[nx][ny] = '*';
				 
			}
		}
	}

}

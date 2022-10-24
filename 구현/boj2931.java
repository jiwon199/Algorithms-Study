import java.util.*;
import java.io.*;

public class Algo2_구미_05_최지원 {

	static int[] dx = { -1, 1, 0, 0 }; // x 방향
	static int[] dy = { 0, 0, -1, 1 }; // y 방향
	static int[][] loadInfo = { { 0, 1 }, { 2, 3 }, { 0, 1, 2, 3 }, { 1, 3 }, { 0, 3 }, { 0, 2 }, { 2, 1 } }; // 각 통로이
																												// 어떤
																												// 방향으로
																												// 연결되는지
																												// 정보 저장
	static Queue<int[]> q; // 통로들 저장할 큐
	static char[][] graph; // 맵 정보 저장할 배열
	static int n, m, ansx, ansy; // 행,열, 정답 위치
	static char ansLoad; // 정답 통로
	static Set<Integer> set; // 정답 통로가 뚫려있는 방향들 저장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입출력

		ansx = 0; // 초기화
		ansy = 0; // 초기화
		ansLoad = '.'; // 초기화
		q = new LinkedList<>(); // 초기화
		set = new HashSet<>(); // 초기화

		StringTokenizer st = new StringTokenizer(br.readLine()); // 입출력
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		graph = new char[n][m]; // 초기화

		for (int i = 0; i < n; i++) { // 모든 행에 대해서
			String line = br.readLine(); // 그 행의 정보 입력받고
			for (int j = 0; j < m; j++) { // 각 칸에 대해서
				char now = line.charAt(j); // 그 칸 정보 입력받고
				graph[i][j] = now; // 그래프에 저장

				// 도로(통로)인 경우 위치와 종류 큐에 저장하기
				if (now == '|')
					q.add(new int[] { i, j, 0 }); // 1번 도로
				else if (now == '-')
					q.add(new int[] { i, j, 1 }); // 2번도로
				else if (now == '+')
					q.add(new int[] { i, j, 2 }); // 3번도로
				else if (now == '1')
					q.add(new int[] { i, j, 3 }); // 4번 도로
				else if (now == '2')
					q.add(new int[] { i, j, 4 }); // 5번 도로
				else if (now == '3')
					q.add(new int[] { i, j, 5 }); // 6번 도로
				else if (now == '4')
					q.add(new int[] { i, j, 6 }); // 7번 도로
			}

		}
		checkLoad(); // 모든 통로 정보를 보며 빈칸 찾기
		makeAnswer(); // 어떤 통로였는지 알아내기
		System.out.println(ansx + " " + ansy + " " + ansLoad); // 출력한다.

	}

	public static void checkLoad() { // 어디가 빈칸인지 알아내는 함수
		while (!q.isEmpty()) { // 모든 통로들에 대해
			int[] info = q.poll(); // 통로 정보
			for (int direction : loadInfo[info[2]]) { // 그 통로와 연결되어 있는 칸을 본다.
				int x = info[0] + dx[direction]; // 연결된 칸 x좌표
				int y = info[1] + dy[direction]; // 연결된 칸 y좌표
				if (graph[x][y] == '.') { // 연결된칸이 빈칸이면 그 칸이 지워진 칸
					ansx = x + 1; // x 정보 저장
					ansy = y + 1; // y 정보 저장
					set.add(getReverseDir(direction)); // 지워진 칸의 통로 정보를 저장
				}
			}

		}
	}

	public static int getReverseDir(int d) { // 반대 방향을 구하는 함수
		if (d == 0)
			return 1; // 위면 아래 반환
		else if (d == 1)
			return 0; // 아래면 위 반환
		else if (d == 2)
			return 3; // 왼쪽이면 오른쪽 반환
		else
			return 2; // 오른쪽이면 왼쪽 반환
	}

	public static void makeAnswer() { // 지워진 칸의 연결된 통로 방향 정보를 보고 어떤 통로인지 알아낸다.
		if (set.contains(0) && set.contains(1) && set.contains(2) && set.contains(3))
			ansLoad = '+'; // 3번 통로인 경우
		else if (set.contains(0) && set.contains(1))
			ansLoad = '|'; // 1번 통로인 경우
		else if (set.contains(2) && set.contains(3))
			ansLoad = '-'; // 2번 통로인 경우
		else if (set.contains(1) && set.contains(3))
			ansLoad = '1'; // 4번 통로인 경우
		else if (set.contains(0) && set.contains(3))
			ansLoad = '2'; // 5번 통로인 경우
		else if (set.contains(0) && set.contains(2))
			ansLoad = '3'; // 6번 통로인 경우
		else if (set.contains(1) && set.contains(2))
			ansLoad = '4'; // 7번 통로인 경우

	}

}

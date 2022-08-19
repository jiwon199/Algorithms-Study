package backjoon;

import java.util.*;
import java.io.*;

public class Main {
	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		n = Integer.parseInt(info[0]);
		k = Integer.parseInt(info[1]);
		// 걸음수를 넣는 배열
		int status[] = new int[100001];
		if (n > k) {
			System.out.println(n - k);
		} else if (n == k) {
			System.out.println(0);
		} else {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			while (!q.isEmpty()) {
				int now = q.poll();
				if (now == k) {
					System.out.println(status[now]);
					break;
				}
				int next = 0;
				for (int i = 0; i < 3; i++) {
					if (i == 0)
						next = now - 1;
					else if (i == 1)
						next = now + 1;
					else
						next = now * 2;
					if (next >= 0 && next < 100001) {
						if (status[next] == 0) {
							q.add(next);
							status[next] = status[now] + 1;
						}
					}
				}
				 
			}
		}
	}

}

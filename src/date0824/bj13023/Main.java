package date0824.bj13023;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M; // N 캠프 인원 M 친구 관계의 수
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);

		}


//		System.out.println(list);
//
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(i + " " + (list[i]));
//		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
		}

		System.out.println(0);

	}

	static void dfs(int x, int depth) {
		if (depth == 4) {
			System.out.println(1);
			System.exit(0);
			return;
		}
		visited[x] = true;
		for (int i = 0; i < list[x].size(); i++) {
			int to = list[x].get(i);
//			visited[to] = true;

			if (!visited[to]) {
//				System.out.println("depth : " + depth);
//				System.out.println(x + " " + to);
				dfs(to, depth + 1);
			}
//			visited[to] = false;
		}
		visited[x] = false;
	}

}

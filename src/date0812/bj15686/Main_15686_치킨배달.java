package date0812.bj15686;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달{

	static int N, M;
	static int[][] map;
	static HashMap<Integer, Integer[]> store = new HashMap<>();
	static int[] saved;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	static List<Integer[]> chicken, house;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0812/bj15686/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		chicken = new LinkedList<>();
		house = new LinkedList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		saved = new int[M];

		Integer key = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					store.put(key, new Integer[] { i, j });
					key++;
					chicken.add(new Integer[] { i, j });
				} else if (map[i][j] == 1) {
					house.add(new Integer[] { i, j });
				}
			}
		}
		visited = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.println(min);

	}

	static void dfs(int idx, int depth) {
		if (depth == M) {
			int temp = checkDist();
			
			if(temp < min) {
				min = temp;
			}
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
//			if(visited[i]) continue;
			saved[depth] = i;
//			visited[i] = true;
			dfs(i + 1, depth + 1);
//			visited[i] = false;
		}

	}

	static int checkDist() {
		int sum = 0;
		int[] temp = new int[house.size()];
		for(int i=0; i< temp.length; i++) {
			temp[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < saved.length; i++) {
			int cx = chicken.get(saved[i])[0];
			int cy = chicken.get(saved[i])[1];
			
			for (int j = 0; j < house.size(); j++) {
				int hx = house.get(j)[0];
				int hy = house.get(j)[1];
				int tempDist = Math.abs(hx - cx) + Math.abs(hy - cy);
				
				if(tempDist < temp[j]) {
					temp[j] = tempDist;
				}
			}
		}
		for(int i=0; i<temp.length; i++) {
			sum += temp[i];
		}
		
		return sum;
		
	}

//		for(int i=0; i<key; i++) {
//			System.out.println(Arrays.toString(store.get(i)));
//		}

}

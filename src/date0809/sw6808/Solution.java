package date0809.sw6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N = 9;
	static int[] cards; // 1~18 총점으로 승리 계산
	static List<Integer> gyu;
	static boolean[] visited;
	static int[] gyuChoice;
	static int loose;
	static int win;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/src/date0809/sw6808/s_input.txt"));
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			win = 0;
			loose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			cards = new int[N];
			gyu = new LinkedList<Integer>();
			gyuChoice = new int[N];
			visited = new boolean[N];
			for(int i=1; i<=18; i++) {
				gyu.add(i);
			}
			
			for(int i=0; i<N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
				gyu.remove(Integer.valueOf(cards[i]));
			}
			
//			System.out.println("Min: " + Arrays.toString(cards));
//			System.out.println("Gyu: " + gyu);
			
			dfs(0);
			
			sb.append("#" + (t+1) +  " ");
			sb.append(win + " " + loose);
			sb.append("\n");

		}
		System.out.println(sb);

	}
	
	static void dfs(int depth) {
		if(depth == N) {
//			System.out.println(Arrays.toString(gyuChoice));
			checkWin();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			gyuChoice[depth] =  gyu.get(i);
			visited[i] = true;
			dfs(depth+1);
			visited[i] = false;
		}
	}
	
	static void checkWin() {
		int scoreMin = 0;
		int scoreGyu = 0;
		for(int i=0; i<9; i++) {
			if(cards[i] > gyuChoice[i]) {
				scoreGyu += gyuChoice[i] + cards[i];
			} else {
				scoreMin += cards[i] + gyuChoice[i];
			}
		}
		if(scoreGyu > scoreMin) win++;
		else loose++;
		return ;
	}
}

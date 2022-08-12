package date0812.bj2529;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static char[] ops;
	static int[] nums;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("HW/HW/src/date0812/bj2529/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		ops = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			ops[i] = st.nextToken().charAt(0);
		}
 		
		int numsize = k+1;
		nums = new int[k+1];
		visited = new boolean[10];
		
		dfs(0);
		
	}
	
	static void dfs(int depth) {
		if(depth == k+1) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		System.out.println(depth + " " + (k+1));
		for(int i=0; i<=9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[depth] = i;
			dfs(depth+1);
			visited[i] = false;
			
		}
	}
	
	static void checkEquality() {
		for(int i=0; i<k; i++) {
			if(ops[i] == '<') {
				
			} else if (ops[i] == '>') {
				
			}
		}
	}
}

import java.io.*;
import java.util.*;

public class Hunter {
	//고객은 음수
	static ArrayList<Integer[]> customers, monsters; 
	//몬스터는 양수
	static int[][] graph;
	
	static boolean[] visitedC, visitedM;
	static int[] choicedC, choicedM;
	
	
	
	static int N, cCnt=0, mCnt=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			customers = new ArrayList<>();
			monsters = new ArrayList<>();
			
			graph = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++ ) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					
					if(graph[i][j] > 0 ) {
						monsters.add(new Integer[] {i, j});
					} else if (graph[i][j] < 0) {
						customers.add(new Integer[] {i, j});
					}
				}
			}
			
			choicedC = new int[customers.size()];
			choicedM = new int[monsters.size()];
			
		}
		
	}
	
	static void dfs(int depth, ArrayList<Integer[]> arr, int[] choiced, boolean[] visited) {
		if(depth == arr.size()) {
			return;
		}
		
		for(int i=0; i<arr.size(); i++) {
			choiced[depth] = arr.get(i)[0];
			visited[i] = true;
		}
	}
	
}

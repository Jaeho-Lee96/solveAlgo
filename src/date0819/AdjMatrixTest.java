package date0819;



import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author THKim
 */
public class AdjMatrixTest {

	static int[][] adjMatrix;
	static int N;
	static boolean visited[];
	int su=1004;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix = new int[N][N]; // 0으로 자동 초기화
		visited = new boolean[N];
		
		for (int i = 0; i < E; i++) { // 간선정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무향그래프
		}
				
//		bfs("안녕,ssafy");
//		AdjMatrixTest test = new AdjMatrixTest();
//		test.bfs("안녕,ssafy");
//		new AdjMatrixTest().bfs("안녕,ssafy");
		
		dfs(0);
	}//main
	
	public static void dfs(int cur) {
		
		visited[cur] = true;
		System.out.print((char)(cur+'A'));
		
		// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
		for (int i = 0; i < N; i++) {
			if(!visited[i] 
			  && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}

	
//	private void bfs(String greeting) {
	private static void bfs(String greeting) {
		//0정점 시작점
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];  // 방문관리 배열
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			//break point ==> 여기부터 찬찬히 봐야 겠어
			int cur = queue.poll(); //당신의 선택을 기다림(멈춰!!)			
			/*
			 
F5 (메서드 안으로 진입 진행)  ==> 메서드 호출때만 F5와 F6이 다르다
F6 (다음 코드 진행)  
F7 (탈출할때 사용) ==> 호출한 곳으로 되돌아 감, line by line 안하겠다 리턴해줘
F8 (다음 브레이크포인트로 이동)
			
			
<Expressions탭>
 ==> 표현식(출력식의 의미)
 ==> System.out.println(A);
     ==> Add new expression을 클릭하여 출력하고자 하는 변수 또는 연산을 입력할 수 있음.
      			
			
			 */
			System.out.print((char)(cur+'A'));
			/*
			  위의 문장 breakpoint
			   - breakpoint에서 오른쪽 마우스 클릭
			   - Conditional 체크
			   - cur==3 입력
			      ==> 3번 정점일때 제어를 기다려!!
			 */
			
			
			// 현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}

}

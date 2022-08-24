package date0824.sw3124;

import java.util.*;
import java.io.*;




public class Solution {

	static int V, E;
	static int[][] edgeList;
	static int[] parents;
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	static void make() { // 크기가 1인 서로 소 집합 생성
		
		parents = new int[V];
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로하는(대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new int[E][3];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				
				edgeList[i] = new int[] {order, from, to};
			}
			
			make();
//			System.out.println(Arrays.toString(parents));

			
			for(int i=0; i<edgeList.length;i++) {
				if(edgeList[i][0] == 0) {
					union(edgeList[i][1], edgeList[i][2]);
				} else {
					if(find(edgeList[i][1]) == find(edgeList[i][2])) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			System.out.println("#" + (t+1) + " " + sb);
		}
		
		
		
		
	}

}




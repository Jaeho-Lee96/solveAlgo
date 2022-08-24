package date0824.sw3289;

import java.util.*;
import java.io.*;




public class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.weight - o.weight);
		}
	}
	static int V, E;
	static Edge[] edgeList;
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
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			
			make();
//			System.out.println(Arrays.toString(parents));
			Arrays.sort(edgeList);
			
			long result = 0;
			int count = 0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++count == V-1) break;
				}
			}
			
			System.out.println("#" + (t+1) + " " + result);
		}
		
		
		
		
	}

}




package date0818.bj1987;

import java.io.*;
import java.util.*;

public class Main_1987_알파벳 {
    static int R, C;

    static Character[][] graph;
    static boolean[][] visited;
    static boolean[] visitAlpha = new boolean[26];

    static LinkedList<Character> alphabets = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0}; // 좌 우 상 하

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("HW/HW/src/date0818/bj1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new Character[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = temp.charAt(j);
            }
        }

        if(R == 1 && C == 1){
            System.out.println(1);
        } else {
            dfs(0, 0, 0);
            System.out.println(max);
        }
    }

    static void dfs(int x, int y, int cnt) {
        if (visited[x][y] || visitAlpha[graph[x][y]-'A']) {
            if(cnt > max) {
                max = cnt;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                visited[x][y] = true;
                visitAlpha[graph[x][y]-'A'] = true;
                dfs(nx, ny, cnt+1);
            }
            visited[x][y] = false;
            visitAlpha[graph[x][y]-'A'] = false;


        }
    }

}

package date0810.bj16926;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/date0810/bj16926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = Math.min(R, C) / 2; //돌아가는 라인?의 수
        for(int n=0; n<N; n++) { //회전 횟수만큼 반복
            for(int j=0; j<count; j++) { //라인들 전부 돌리기
                int temp = arr[j][j]; //맨 마지막에 넣기 위해 따로 저장!!!!배열에서 원소 위치 바꿀때 하나를 temp에 저장해두는거랑 같은 원리

                for(int k=j+1; k<C-j; k++)
                    arr[j][k-1] = arr[j][k];

                for(int k=j+1; k<R-j; k++)
                    arr[k-1][C-1-j] = arr[k][C-1-j];

                for(int k=C-2-j; k>=j; k--)
                    arr[R-1-j][k+1] = arr[R-1-j][k];

                for(int k=R-2-j; k>=j; k--)
                    arr[k+1][j] = arr[k][j];

                arr[j+1][j] = temp;
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
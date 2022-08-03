package date0803.sw2001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution_2001_파리퇴치
{
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
         
        for(int t=0;t<T;++t) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nm.nextToken()); // 5 <= N <= 15
            int M = Integer.parseInt(nm.nextToken()); // 2 <= M <= 2 NM 크기가 작으므로 n^4 가능 30초
             
            int[][] arr = new int[N][N];
             
            for(int i=0; i<N; ++i) {
                StringTokenizer val = new StringTokenizer(br.readLine());
                for(int j=0; j<N; ++j) {
                    arr[i][j] = Integer.parseInt(val.nextToken());
                }
            }
            int answer = getMax(arr, M);
            System.out.println("#" + (t+1) + " " + answer);
//          System.out.println(Arrays.deepToString(arr));
         
    }
    } // main
     
    static int getMax(int[][] arr, int M) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-M+1;++i) {
            for(int j=0;j<arr.length-M+1;++j) {
                int sum = 0;
                for(int m=0;m<M; ++m) {
                    for(int k=0;k<M; ++k) {
                        sum += arr[i+m][j+k];
                    }
                }
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
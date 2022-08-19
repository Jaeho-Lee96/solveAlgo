package date0819.sw3234;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution2{
 
    static int N,ans,sC;
    static int[] chu = new int[9], sW = new int[9];
 
    static void DFS2(int idx, int left, int right) {
        if(right>left) return;
        if(idx == N) {
            ans++;
            return;
        }
        DFS2(idx+1,left + sW[idx],right);
        DFS2(idx+1,left ,right+ sW[idx]);
    }
     
    static void DFS(int idx) {
        if(idx==N) {
            DFS2(0,0,0);
            return;
        }
        for(int i = 0 ; i < N; i++) {
            if((sC & (1 << i)) == 0) {
                sC |= (1 << i);
                sW[idx] = chu[i];
                DFS(idx+1);
                sC &= ~ (1 << i);
            }
        }
    }
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            ans = 0;
            sC = 0;
 
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++)
                chu[i] =  Integer.parseInt(st.nextToken()); 
 
            DFS(0);         
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
            System.out.print(sb);
        }
    }
}

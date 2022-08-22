package date0822.bj1759;

import java.io.*;
import java.util.*;

public class Main_1759_암호만들기 {
    static int L, C;
    static ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static char[] alphabets;
    static char[] password;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabets);
        dfs(0, 0);
    }

    static void dfs(int idx, int depth) {
        if (depth == L) {
            if(checkVowel()) {
                for (char c : password) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            password[depth] = alphabets[i];
            dfs(i + 1, depth + 1);
        }
    }

    static boolean checkVowel() {
        int vowelCnt = 0;
        int cnt = 0;
        for (char c : password) {
            if (vowels.contains(c)) {
                vowelCnt++;
            } else {
                cnt++;
            }
        }
        return vowelCnt > 0 && cnt > 1;
    }

}


package date0805.bj12891;
import java.io.*;
import java.util.*;

public class Main {
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken()); // 주어진 문자열
	int M = Integer.parseInt(st.nextToken()); // 사용할 부분문자열의 길이
	arr = new int[4];
	String input = br.readLine();
	
	st = new StringTokenizer(br.readLine());
	for (int i = 0; i < 4; i ++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}
	
	int count[] = new int[4];
	int answer = 0;
	
	int right = M;
	int left = 0;
	
	for (int i = 0; i < M; i ++) { // 초기값에 몇번 들어가는지
		if (input.charAt(i) == 'A') {
			count[0] += 1;
		} else if (input.charAt(i) == 'C') {
			count[1] += 1;
		}  else if (input.charAt(i) == 'G') {
			count[2] += 1;
		}  else if (input.charAt(i) == 'T') {
			count[3] += 1;
		}
	}
	
	
	if (check(count)) answer++;
	
	for (int i = M; i < N; i ++) {
		char addChar = input.charAt(right++);
		if (addChar == 'A') {
			count[0] += 1;
		}  else if (addChar == 'C') {
			count[1] += 1;
		}  else if (addChar == 'G') {
			count[2] += 1;
		}  else if (addChar == 'T') {
			count[3] += 1;
		}
		
		char removeChar = input.charAt(left++);
		if (removeChar == 'A') {
			count[0] -= 1;
		}  else if (removeChar == 'C') {
			count[1] -= 1;
		}  else if (removeChar == 'G') {
			count[2] -= 1;
		}  else if (removeChar == 'T') {
				count[3] -= 1;
			}
			
			if (check(count)) answer++;
		}
		
		sb.append(answer);
		System.out.println(sb);

	}
	public static boolean check(int count[]) {
		for (int i = 0; i < 4; i ++) {
			if (count[i] < arr[i]) return false;
		}
		return true;
	}
}
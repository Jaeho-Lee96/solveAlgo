package date0801.bj1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/date0801/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] switchs = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<switchs.length;++i) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
				
		int students = Integer.parseInt(br.readLine());
		for(int i=0; i< students; ++i) {
			StringTokenizer stu = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(stu.nextToken());
			int loc = Integer.parseInt(stu.nextToken());
			if(gender == 1) {
				changeSwitchMale(switchs, loc);
//				System.out.println(Arrays.toString(switchs));
			} else {
				changeSwitchFemale(switchs, loc);
//				System.out.println(Arrays.toString(switchs));
			}
		}
		
		for(int i=1;i<switchs.length; ++i) {
			System.out.print(switchs[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
		
	}
	
	static void changeSwitchMale(int[] arr, int loc) {
		for(int i=1; i<arr.length; ++i) {
			if(i % loc == 0) {
				arr[i] = (arr[i] == 1) ? 0 : 1;
			}
		}
	}
	
	static void changeSwitchFemale(int[] arr, int loc) {
		int maxLen = (arr.length - loc >  loc) ? loc  : arr.length-loc;
		// 갈 수 있는 최대 거리 구하기
//		System.out.println(maxLen);
		arr[loc] = (arr[loc] == 1) ? 0 : 1;
		for(int i=0; i< maxLen; ++i) {
			if(arr[loc-i] == arr[loc+i]) {
//				System.out.println(Arrays.toString(arr));

				arr[loc-i] = (arr[loc-i] == 1) ? 0 : 1;
//				System.out.println(Arrays.toString(arr));

				arr[loc+i] = (arr[loc+i] == 1) ? 0 : 1;
			} else {
				break;
			}
		}
	}
	
}
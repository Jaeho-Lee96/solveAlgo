package date0812;

public class Recursive3 {
	static int sum = 0;
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		int sumParam = 0;
		recur(0, arr, sumParam);
		System.out.println(sum);
	}
	
	//static 보다 param 이 좀 더 빠르다
	static void recur(int idx, int[] arr, int sumParam) {
		if(idx >= arr.length) {
			System.out.println(sumParam);
			return;
		}
		
		System.out.println(arr[idx]);
		sum += arr[idx]; // recursive 2번 이상사용할 때 이전과 같은 문제 있을 수 있음
		recur(idx+1, arr, sumParam+ arr[idx]);
	}
	
}

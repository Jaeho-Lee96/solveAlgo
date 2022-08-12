package date0812;

public class Recursive2 {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		recur(0, arr);
	}
	
	//static 보다 param 이 좀 더 빠르다
	static void recur(int idx, int[] arr) {
		if(idx >= arr.length) return;
		
		System.out.println(arr[idx]);
		recur(idx+1, arr);
	}
	
}

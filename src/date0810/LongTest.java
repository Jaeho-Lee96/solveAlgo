package date0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LongTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        long a =  sc.nextLong();
        System.out.println(Long.parseLong(br.readLine()));
        System.out.println(a);
    }
}

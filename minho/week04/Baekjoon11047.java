package minho.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int sum = 0;
        int index = n - 1;
        while (sum != k) {
            if (sum + arr[index] > k) {
                index -= 1;
                continue;
            }

            sum += arr[index];
            result += 1;
            //System.out.println(sum);
        }

        System.out.println(result);
    }
}

package minho.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String[] str = br.readLine().split(" ");

        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);

        int[] arr = new int[1000001];
        boolean[] arr_check = new boolean[1000001];

        for (int i = x; i <= y; i++) {
            arr[i] = i;
            arr_check[i] = true;
        }

        if (x == 1) {
            arr_check[1] = false;
        }

        for (int i = 2; i <= y; i++) {
            for (int j = (i + i); j <= y; j += i) {
                if (arr_check[j] && j % j == 0) {
                    arr_check[j] = false;
                }
            }
        }

        for (int i = x; i <= y; i++) {
            if (arr_check[i]) {
                System.out.println(i);
            }
        }
    }
}

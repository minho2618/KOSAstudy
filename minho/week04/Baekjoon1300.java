// https://www.acmicpc.net/problem/1300

package minho.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int j = 0; j < num; j++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr.get(i).add(j, (i + 1) * (j + 1));
            }
        }

        ArrayList<Integer> arrB = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arrB.add(arr.get(i).get(j));
            }
        }

        arrB.sort((n1, n2) -> {
            return n1 - n2;
        });

        // System.out.println(arrB);

        str = br.readLine();
        num = Integer.parseInt(str);
        System.out.println(arrB.get(num - 1));
    }
}

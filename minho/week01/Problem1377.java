package minho.week01;

// https://www.acmicpc.net/problem/1377
// 2025.04.29

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // for (int n : list) System.out.println(n);

        
    }
}
